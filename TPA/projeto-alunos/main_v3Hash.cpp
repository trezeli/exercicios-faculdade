// Tempo de leitura: 820.00 segundos - Hash 100
// Tempo de leitura: 385.00 segundos - Hash 1000
// Tempo de leitura: 64.00 segundos - Hash 10000
// Tempo de leitura: 44.00 segundos - Hash 100000

#include <cstdio>
#include <cstdlib>
#include <ctime>
#include <string.h>

// Estruturas
struct Aluno{
    char matricula[9];
    char cpf[15];
    char nome[40];
    double nota;
    int idade;
    char curso[40];
    char cidade[40];
    Aluno *prox;
    Aluno *ante;
};

struct Alunos{
    Aluno *inicio;
    Aluno *fim;
    int quantidade;
};

// Funções - Protótipos
Aluno* buscaCpf(const char* cpf);
void adicionarAluno(Aluno* novo);
void mostrarAluno(Aluno* aluno);
void removerAluno(Aluno* aluno);
void mostrarERemover(Aluno* aluno);
void menu();

// Variáveis globais
Alunos a[100000];

// Funções - Implementações
void inicializa(){
    for (int i = 0; i < 100000; i++){
        a[i].inicio = NULL;
        a[i].fim = NULL;
        a[i].quantidade = 0;
    }
}

int hashCPF(char *cpf){
    int digito;

    int dezena = cpf[12] - '0';
    int unidade = cpf[13] - '0';
    digito = dezena * 10 + unidade;
    return digito;
}

int hashCPF1000(char *cpf){
    int resultado = 0;

    for (int i = 0; i < 14; i++){
        if (cpf[i] >= '0' && cpf[i] <= '9'){
            resultado += (cpf[i] - '0') * (i + 1);
        }
    }

    return resultado % 1000;
}

int hashCPF10000(char *cpf){
    int parte1 = (cpf[0]-'0') * 100 + (cpf[1]-'0') * 10 + (cpf[2]-'0');
    int parte2 = (cpf[4]-'0') * 100 + (cpf[5]-'0') * 10 + (cpf[6]-'0');
    int parte3 = (cpf[8]-'0') * 100 + (cpf[9]-'0') * 10 + (cpf[10]-'0');
    int verificadores = (cpf[12]-'0') * 10 + (cpf[13]-'0');

    return (parte1 + parte2 * 2 + parte3 * 3 + verificadores * 4) % 10000;
}

int hashCPF100000(char *cpf){
    int resultado = 0;

    for (int i = 0; i < 14; i++){
        if (cpf[i] >= '0' && cpf[i] <= '9'){
            resultado = (resultado * 31 + (cpf[i] - '0')) % 100000;
        }
    }

    return resultado;
}

Aluno* buscaCpf(const char* cpf)
{
    int indice = hashCPF100000((char*)cpf);
    Aluno* atual = a[indice].inicio;

    while(atual != NULL){
        if (strcmp(atual->cpf, cpf) == 0)  {
            return atual;
        }
        atual = atual->prox;
    }

    return NULL;
}

void adicionarAluno(Aluno* novo)
{  
   int indice = hashCPF100000(novo->cpf);

   if (buscaCpf(novo->cpf) != NULL){
        delete novo;
        return;
   }

    if (a[indice].inicio == NULL){
        a[indice].inicio = novo;
        a[indice].fim = novo;

        novo->ante = NULL;
        novo->prox = NULL;

        a[indice].quantidade++;
        return;
    }   

    if (strcmp(novo->nome, a[indice].inicio->nome) < 0){
        novo->prox = a[indice].inicio;
        a[indice].inicio->ante = novo;
        a[indice].inicio = novo;

        novo->ante = NULL;

        a[indice].quantidade++;
        return;
    }

    Aluno* atual = a[indice].inicio;
    while (atual != NULL){
        if(strcmp(novo->nome, atual->nome) < 0){
            Aluno* anterior = atual->ante;

            novo->prox = atual;
            anterior->prox = novo;
            atual->ante = novo;
            novo->ante = anterior;

            a[indice].quantidade++;
            return;
        }
        atual = atual->prox;
    }

    a[indice].fim->prox = novo;
    novo->ante = a[indice].fim;
    novo->prox = NULL;
    a[indice].fim = novo;

    a[indice].quantidade++;
   
}

void removerAluno(Aluno* aluno)
{
    int indice = hashCPF100000(aluno->cpf);

    if (aluno->ante == NULL && aluno->prox == NULL){ // unico
        a[indice].inicio = NULL;
        a[indice].fim = NULL;
    } 
    else if (aluno->ante == NULL) {                // primeiro
        a[indice].inicio = aluno->prox;
        aluno->prox->ante = NULL;
    } 
    else if (aluno->prox == NULL) {                // ultimo
        a[indice].fim = aluno->ante;
        aluno->ante->prox = NULL;
    } 
    else {                                        // meio
        aluno->ante->prox = aluno->prox;
        aluno->prox->ante = aluno->ante;
    }

    a[indice].quantidade--;
    delete aluno;
}

void mostrarAluno(Aluno* aluno)
{
    printf("  Matricula: %s\n", aluno->matricula);
    printf("  CPF: %s\n", aluno->cpf);
    printf("  Nome: %s\n", aluno->nome);
    printf("  Nota: %.2f\n", aluno->nota);
    printf("  Idade: %d\n", aluno->idade);
    printf("  Curso: %s\n", aluno->curso);
    printf("  Cidade: %s\n", aluno->cidade);
        
}

void mostrarERemover(Aluno* aluno)
{
    mostrarAluno(aluno);

    char resposta;

    printf("Deseja remover este aluno? (S/N): ");
    scanf(" %c", &resposta);

    if (resposta == 's' || resposta == 'S') {
        removerAluno(aluno);
        printf("Aluno removido!\n");
    }
}

// Função para exibir todos os alunos
void exibirAlunos() {
    printf("\n=== LISTA DE ALUNOS ===\n");
    
    int contador = 1;

    for (int i = 0; i < 100000; i++) {
        Aluno* atual = a[i].inicio;
        
            while (atual != NULL) {
                printf("Aluno %d:\n", contador);
                printf("  Matricula: %s\n", atual->matricula);
                printf("  CPF: %s\n", atual->cpf);
                printf("  Nome: %s\n", atual->nome);
                printf("  Nota: %.2f\n", atual->nota);
                printf("  Idade: %d\n", atual->idade);
                printf("  Curso: %s\n", atual->curso);
                printf("  Cidade: %s\n", atual->cidade);
                printf("  ---\n");
                
                atual = atual->prox;
                contador++;
            }
    }
    printf("Total: %d alunos\n\n", contador - 1);
}

// Função para ler arquivo CSV
void lerArquivoCSV(const char* nomeArquivo) {
    FILE* arquivo = fopen(nomeArquivo, "r");
    if (arquivo == NULL) {
        printf("Erro ao abrir o arquivo %s\n", nomeArquivo);
        return;
    }
    char linha[300];
    
    printf("Iniciando leitura do arquivo CSV...\n");
    
    // Pular a primeira linha (cabeçalho)
    if (fgets(linha, sizeof(linha), arquivo) == NULL) {
        printf("Arquivo vazio ou erro na leitura\n");
        fclose(arquivo);
        return;
    }
    
    // Ler cada linha usando fscanf diretamente na struct
    Aluno* novo;
    while ((novo = new Aluno) != NULL) {
        //%N significa que fará a leitura de até N caracteres, evitando overflow
        //O [^caractere] é uma classe de caracteres negativa - significa "qualquer caractere EXCETO o especificado".
        //É muito útil para parar a leitura quando encontrar um delimitador específico (como vírgula ou quebra de linha).
        if (fscanf(arquivo, "%8[^,],%14[^,],%39[^,],%lf,%d,%39[^,],%39[^\n]\n", 
                   novo->matricula, novo->cpf, novo->nome, &novo->nota, &novo->idade, novo->curso, novo->cidade) == 7) {
            
            // Inicializar ponteiros da lista
            novo->prox = NULL;
            novo->ante = NULL;

            adicionarAluno(novo);
            printf("Aluno adicionado: %s\n", novo->matricula);
            // Consumir a quebra de linha restante
            //fgetc(arquivo);
        } else {
            // Se não conseguiu ler todos os campos, liberar memória e sair
            delete novo;
            break;
        }
    }
    
    fclose(arquivo);

    int total = 0;
    for (int i = 0; i < 100000; i++) {
        total += a[i].quantidade;
    }

    printf("Leitura concluida. Total de alunos: %d\n", total);
}

void menu()
{
    int op;

    do {
        printf("\n===== MENU =====\n");
        printf("1 - Buscar por CPF\n");
        printf("2 - Exibir alunos\n");
        printf("0 - Sair\n");
        printf("Escolha uma opcao: ");
        scanf("%d", &op);

        switch (op) {
            case 1: {
                char cpf[15];

                printf("Insira CPF: \n");
                scanf("%14s", cpf);

                Aluno* aluno = buscaCpf(cpf);

                if (aluno != NULL){
                    mostrarERemover(aluno);
                }
                else{
                    printf("CPF nao encontrado\n");
                }
                break;
            }

            case 2:
                exibirAlunos();
                break;

            case 0:
                printf("Saindo...\n");
                break;

            default:
                printf("Opcao invalida!\n");
        }

    } while (op != 0);
}

// Função principal
int main(){
    inicializa();
    printf("=== SISTEMA DE LEITURA DE ALUNOS CSV ===\n\n");
    
    time_t inicio, fim;
    inicio = time(NULL);
    // Ler arquivo CSV (você pode alterar o nome do arquivo) Essa função já cria a lista dinâmica com os alunos
    lerArquivoCSV("alunos_completosV2.csv");
    
    fim = time(NULL);
    //se eu quiser pegar como inteiro o valor do tempo
    // time_t tempo;
    // tempo = fim - inicio;
    // printf("Tempo de leitura: %d segundos\n", (int)tempo);
    //se eu quiser pegar como double o valor do tempo
    double tempo = difftime(fim, inicio);
    printf("Tempo de leitura: %.2f segundos\n", tempo);
    // Exibir todos os alunos carregados
    //exibirAlunos();
    menu();

    system("pause");
    return 0;
}
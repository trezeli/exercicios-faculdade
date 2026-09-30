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
Aluno* buscaMatricula(const char* matricula);
void adicionarAluno(Aluno* novo);
void mostrarAluno(Aluno* aluno);
void removerAluno(Aluno* aluno);
void mostrarERemover(Aluno* aluno);
void menu();

// Variáveis globais
Alunos a;

// Funções - Implementações
void inicializa(){
    a.inicio = NULL;
    a.fim = NULL;
    a.quantidade = 0;
}

Aluno* buscaCpf(const char* cpf)
{
    Aluno* atual = a.inicio;

    while(atual != NULL){
        if (strcmp(atual->cpf, cpf) == 0)  {
            return atual;
        }
        atual = atual->prox;
    }

    return NULL;
}

Aluno* buscaMatricula(const char* matricula)
{
    Aluno* atual = a.inicio;

    while(atual != NULL){
        if (strcmp(atual->matricula, matricula) == 0)  {
            return atual;
        }
        atual = atual->prox;
    }
    
    return NULL;
}

void adicionarAluno(Aluno* novo)
{
   if (buscaCpf(novo->cpf) != NULL){
        delete novo;
        return;
   }

   if (buscaMatricula(novo->matricula) != NULL){
        delete novo;
        return;
   }

    if (a.inicio == NULL){
        a.inicio = novo;
        a.fim = novo;

        novo->ante = NULL;
        novo->prox = NULL;

        a.quantidade++;
        return;
    }   

    if (strcmp(novo->nome, a.inicio->nome) < 0){
        novo->prox = a.inicio;
        a.inicio->ante = novo;
        a.inicio = novo;

        novo->ante = NULL;

        a.quantidade++;
        return;
    }

    Aluno* atual = a.inicio;
    while (atual != NULL){
        if(strcmp(novo->nome, atual->nome) < 0){
            Aluno* anterior = atual->ante;

            novo->prox = atual;
            anterior->prox = novo;
            atual->ante = novo;
            novo->ante = anterior;

            a.quantidade++;
            return;
        }
        atual = atual->prox;
    }

    a.fim->prox = novo;
    novo->ante = a.fim;
    novo->prox = NULL;
    a.fim = novo;

    a.quantidade++;
   
}

void removerAluno(Aluno* aluno)
{
    if (aluno->ante == NULL && aluno->prox == NULL){ // unico
        a.inicio = NULL;
        a.fim = NULL;
    } 
    else if (aluno->ante == NULL) {                // primeiro
        a.inicio = aluno->prox;
        aluno->prox->ante = NULL;
    } 
    else if (aluno->prox == NULL) {                // ultimo
        a.fim = aluno->ante;
        aluno->ante->prox = NULL;
    } 
    else {                                        // meio
        aluno->ante->prox = aluno->prox;
        aluno->prox->ante = aluno->ante;
    }

    a.quantidade--;
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
    Aluno* atual = a.inicio;
    int contador = 1;
    
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
    printf("Total: %d alunos\n\n", a.quantidade);
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
            //printf("Aluno adicionado: %s - %s\n", novo->matricula, novo->nome);
            // Consumir a quebra de linha restante
            //fgetc(arquivo);
        } else {
            // Se não conseguiu ler todos os campos, liberar memória e sair
            delete novo;
            break;
        }
    }
    
    fclose(arquivo);
    printf("Leitura concluida. Total de alunos: %d\n", a.quantidade);
}

void menu()
{
    int op;

    do {
        printf("\n===== MENU =====\n");
        printf("1 - Buscar por CPF\n");
        printf("2 - Buscar por matricula\n");
        printf("3 - Exibir alunos\n");
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

            case 2: {
                char matricula[9];

                printf("Insira matricula: \n");
                scanf("%8s", matricula);
                
                Aluno* aluno = buscaMatricula(matricula);

                if (aluno != NULL){
                    mostrarERemover(aluno);
                }
                else{
                    printf("Matricula nao encontrada\n");
                }
                break;
            }

            case 3:
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
    menu();
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
    
    system("pause");
    return 0;
}
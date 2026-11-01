public class ArvoreBuscaBinaria {

    private No raiz;

    public ArvoreBuscaBinaria() {
        this.raiz = null;
    }

    public void inserir(int dado) {
        raiz = inserirRecursivo(raiz, dado);
    }

    private No inserirRecursivo(No atual, int dado) {
        if (atual == null) {
            atual = new No(dado);
            return atual;
        }

        if (dado < atual.dado) {
            atual.esquerda = inserirRecursivo(atual.esquerda, dado);
        } else if (dado > atual.dado) {
            atual.direita = inserirRecursivo(atual.direita, dado);
        }

        return atual;
    }

    public boolean buscar(int dado) {
        return buscarRecursivo(raiz, dado);
    }

    private boolean buscarRecursivo(No atual, int dado) {
        if (atual == null) {
            return false;
        }

        if (atual.dado == dado) {
            return true;
        }

        if (dado < atual.dado) {
            return buscarRecursivo(atual.esquerda, dado);
        } else {
            return buscarRecursivo(atual.direita, dado);
        }
    }


    public void remover(int dado) {
        raiz = removerRecursivo(raiz, dado);
    }

    private No buscarMenor(No atual) {
        while (atual.esquerda != null) {
            atual = atual.esquerda;
        }
        return atual;
    }

    private No removerRecursivo(No atual, int dado) {

        if (atual == null) {
            return null;
        }

        if (dado < atual.dado) {
            atual.esquerda = removerRecursivo(atual.esquerda, dado);

        } else if (dado > atual.dado) {
            atual.direita = removerRecursivo(atual.direita, dado);

        } else {

            // Caso 1: Nó folha
            if (atual.esquerda == null && atual.direita == null) {
                return null;
            }

            // Caso 2: Nó tem apenas um filho
            else if (atual.esquerda == null) {
                return atual.direita;

            } else if (atual.direita == null) {
                return atual.esquerda;
            }

            // Caso 3: Nó tem dois filhos
            else {
                No sucessor = buscarMenor(atual.direita);

                atual.dado = sucessor.dado;

                atual.direita = removerRecursivo(atual.direita, sucessor.dado);
            }
        }

        return atual;
    }

    public void imprimirEmOrdem(){
        imprimirEmOrdemRecursivo(raiz);
    }

    private void imprimirEmOrdemRecursivo(No atual){
        if (atual != null){
            imprimirEmOrdemRecursivo(atual.esquerda);
            System.out.print(atual.dado + " ");
            imprimirEmOrdemRecursivo(atual.direita);
        }
    }

    public void imprimirPreOrdem(){
        imprimirPreOrdemRecursivo(raiz);}

    private void imprimirPreOrdemRecursivo(No atual){
        if (atual != null){
            System.out.print(atual.dado + " ");
            imprimirPreOrdemRecursivo(atual.esquerda);
            imprimirPreOrdemRecursivo(atual.direita);
        }
    }

    public void imprimirPosOrdem(){
        imprimirPosOrdemRecursivo(raiz);
    }

    private void imprimirPosOrdemRecursivo(No atual){
        if (atual != null){
            imprimirPosOrdemRecursivo(atual.esquerda);
            imprimirPosOrdemRecursivo(atual.direita);
            System.out.print(atual.dado + " ");

        }
    }

    public int altura(){
        return alturaRecursivo(raiz);
    }

    private int alturaRecursivo(No atual){
        if (atual == null){
            return -1;
        }

        int alturaEsquerda = alturaRecursivo(atual.esquerda);
        int alturaDireita = alturaRecursivo(atual.direita);

        return 1 + Math.max(alturaEsquerda, alturaDireita);
    }

    public int contarNos(){
        return contarNosRecursivo(raiz);
    }

    public int contarNosRecursivo(No atual){
        if (atual == null){
            return 0;
        }

        int nosEsquerda = contarNosRecursivo(atual.esquerda);
        int nosDireita = contarNosRecursivo(atual.direita);

        return nosDireita + nosEsquerda + 1;
    }

    public int contarFolhas(){
        return contarFolhasRecursivo(raiz);
    }

    public int contarFolhasRecursivo(No atual){
        if (atual == null){
            return 0;
        }

        if (atual.esquerda == null && atual.direita == null){
            return 1;
        } else{ return contarFolhasRecursivo(atual.esquerda) + contarFolhasRecursivo(atual.direita);
        }
    }

    public int profundidadeNo(int valor){
        return profundidadeNoRecursivo(raiz, valor, 0);
    }

    public int profundidadeNoRecursivo(No atual, int valor, int profundidade){
        if (atual == null){
            return -1;
        }

        if (atual.dado == valor){
            return profundidade;
        }

        if (valor < atual.dado){
            return profundidadeNoRecursivo(atual.esquerda, valor, profundidade + 1);
        } else {return profundidadeNoRecursivo(atual.direita, valor, profundidade + 1);
        }
    }
}



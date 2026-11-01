//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ArvoreBuscaBinaria arvore = new ArvoreBuscaBinaria();

        arvore.inserir(50);
        arvore.inserir(30);
        arvore.inserir(70);
        arvore.inserir(20);
        arvore.inserir(40);
        arvore.inserir(60);
        arvore.inserir(80);

        System.out.println("Buscar 30: " + arvore.buscar(30));

        System.out.print("Em ordem: ");
        arvore.imprimirEmOrdem();
        System.out.println();

        System.out.print("Pré-ordem: ");
        arvore.imprimirPreOrdem();
        System.out.println();

        System.out.print("Pós-ordem: ");
        arvore.imprimirPosOrdem();
        System.out.println();

        arvore.remover(30);

        System.out.print("Após remover 30: ");
        arvore.imprimirEmOrdem();
        System.out.println();

        System.out.println("Altura: " + arvore.altura());
        System.out.println("Total de nós: " + arvore.contarNos());
        System.out.println("Total de folhas: " + arvore.contarFolhas());
        System.out.println("Profundidade do nó 60: " + arvore.profundidadeNo(60));
    }
}
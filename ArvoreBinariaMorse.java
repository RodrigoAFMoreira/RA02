package avaliacao2;

import java.util.Scanner;

/**
 *
 * @author RAFMo
 */
class No {

    char info; // armazena letra/número
    No ponto; // equerda '.'
    No linha;  //direita '-'

    
    No() {
        this.info = '\0'; // representar vazio p/ causa do char
        this.ponto = null;
        this.linha = null;
    }
}

public class ArvoreBinariaMorse {

    private No raiz; 

    
    public void inicializa() {
        raiz = new No(); 
        popularArvore();   
    }
    
// metodo para popular a arvore
    private void popularArvore() {
        // Letras
    insere(".", 'E');
    insere("-", 'T');
    insere("..", 'I');
    insere(".-", 'A');
    insere("-.", 'N');
    insere("--", 'M');
    insere("...", 'S');
    insere("..-", 'U');
    insere(".-.", 'R');
    insere(".--", 'W');
    insere("-..", 'D');
    insere("-.-", 'K');
    insere("--.", 'G');
    insere("---", 'O');
    insere("....", 'H');
    insere("...-", 'V');
    insere("..-.", 'F');
    insere(".-..", 'L');
    insere(".--.", 'P');
    insere(".---", 'J');
    insere("-...", 'B');
    insere("-..-", 'X');
    insere("-.-.", 'C');
    insere("-.--", 'Y');
    insere("--..", 'Z');
    insere("--.-", 'Q');

    insere(".....", '5');
    insere("....-", '4');
    insere("...--", '3');
    insere("..---", '2');
    insere(".----", '1');
    insere("-....", '6');
    insere("--...", '7');
    insere("---..", '8');
    insere("----.", '9');
    insere("-----", '0');

    insere(".-.-", '+'); 
    insere("-.-.-", '=');  
    }

// metodo para inserir um caractere relativo ao codigo morse
    public void insere(String codigoMorse, char caractere) {
        No noAtual = raiz;
        for (char simbolo : codigoMorse.toCharArray()) {
            if (simbolo == '.') {
                if (noAtual.ponto == null) {
                    noAtual.ponto = new No(); // cria no para esquerda se não existir
                }
                noAtual = noAtual.ponto; // move para filho ponto
            } else if (simbolo == '-') {
                if (noAtual.linha == null) {
                    noAtual.linha = new No(); // cria no para direita se não existir
                }
                noAtual = noAtual.linha; // move para filho linha
            }
        }
        noAtual.info = caractere; // atribui o caractere no final
    }
    // busca
    public char busca(String codigoMorse) {
        No noAtual = raiz;
        for (char simbolo : codigoMorse.toCharArray()) {
            if (simbolo == '.') {
                noAtual = noAtual.ponto;
            } else if (simbolo == '-') {
                noAtual = noAtual.linha; 
            }
            if (noAtual == null) {
                return '\0'; // retorna nulo se não existir
            }
        }
        return noAtual.info; // retorna o caractere encontrado
    }

    // pedir input do user e decodificar 
    public void decodifica() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o codigo morse com letras/numero separada(o)s por espaco");
        String input = scanner.nextLine();
        String[] letrasMorse = input.split(" "); // divide p espaço

        StringBuilder palavra = new StringBuilder();
        for (String letraMorse : letrasMorse) {
            char caractere = busca(letraMorse);
            if (caractere != '\0') { // dif de null
                palavra.append(caractere);
            } else {
                System.out.println("codigo invalido: " + letraMorse);
            }
        }

        System.out.println("A palavra decodificada: " + palavra.toString());
        
        
    }

    public static void main(String[] args) {
        ArvoreBinariaMorse arvore = new ArvoreBinariaMorse();
        arvore.inicializa();

        // Teste 
        /*System.out.println(arvore.busca(".-."));   
        System.out.println(arvore.busca("---"));    
        System.out.println(arvore.busca("-.."));     
        System.out.println(arvore.busca(".-."));  
        System.out.println(arvore.busca(".."));    
        System.out.println(arvore.busca("--.")); 
        System.out.println(arvore.busca("---"));*/ 
        arvore.decodifica();
    }
}

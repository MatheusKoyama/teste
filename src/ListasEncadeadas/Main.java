package ListasEncadeadas;

public class Main {

    public static void main(String[] args) {

        Lista lista = new Lista<Integer>();

         
        for (int i = 0; i < 10; i++) {
            lista.InsereInicial(i);
        }
     

        System.out.println(lista);
        System.out.println();
        
        
        lista.RemoveInicial();
       System.out.println(lista);
        
        lista.RemoveFinal();
        lista.Remove(5);
        
        System.out.println(lista);
        System.out.println(lista.Busca(5));
  

}
}

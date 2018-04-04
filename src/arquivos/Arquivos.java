package arquivos;
public class Arquivos {
    public static void main(String[] args) {
    int [] vetor = {19,22,60,42,3,36};
   
    MegaSena obj1= new MegaSena("megasena.txt");
    obj1.checarAcertos(vetor);
    obj1.histograma();
    
    //obj1.lerArquivo();
        
    }
    
}

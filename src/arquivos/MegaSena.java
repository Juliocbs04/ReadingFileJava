package arquivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class MegaSena {
    private String nomeArquivo= "megasena.txt";
    private Scanner sc;
    int [][] gabarito = new int [2019][7];
    
    public MegaSena(String novoNomeArquivo){
        nomeArquivo= novoNomeArquivo;
    }
    

    /*
    public void lerArquivo(){
        int contador=0;
        while(sc.hasNext()){
           gabarito[contador][0]=sc.nextInt();
           gabarito[contador][1]= sc.nextInt();
           gabarito[contador][2]= sc.nextInt();
           gabarito[contador][3]= sc.nextInt();
           gabarito[contador][4]= sc.nextInt();
           gabarito[contador][5]= sc.nextInt();
           gabarito[contador][6]= sc.nextInt();
           System.out.printf("\n %d %d %d %d %d %d %d",gabarito[contador][0],gabarito[contador][1],gabarito[contador][2],gabarito[contador][3],gabarito[contador][4],gabarito[contador][5],gabarito[contador][6]);
           contador++;
        }
    }
    */
    public void checarAcertos(int [] vetor){ //  Recebe um vetor de até 15 elementos e informa se aqueles números foram sorteados em algum dos concursos ocorridos
        int [] v= new int[6];
        int sorteio=0,contador=0;
        //abertura do arquivo
        try {
            sc = new Scanner(new File(nomeArquivo));
        } catch (FileNotFoundException ex) {
            System.err.println("Nao foi possível abrir o arquivo!");
        }
        
        
        while(sc.hasNext()){
            sorteio= sc.nextInt();
            for(int i=0;i<6;i++){
                v[i]= sc.nextInt();
            }for(int j=0;j<6;j++){
                for(int k=0;k<6;k++){
                    if(v[j]==vetor[k]){
                       contador++;
                    }  
                }
            }       
                  
            
            
            if(contador==4){
                System.out.printf("\n O usuario no sorteio %d acertou %d e ganhou a Quadra",sorteio,contador);
                
            }else if(contador==5){
                System.out.printf("\n O usuario no sorteio %d acertou %d e ganhou a Quina",sorteio,contador);
            }else if(contador==6){
                System.out.printf("\n O usuario no sorteio %d acertou %d e ganhou a Sena",sorteio,contador);
            }
            
                contador=0;
            
        }
        sc.close();
        
    }
    
    public void histograma(){ // Este método determina o número de ocorrências de cada um dos 60 números possíveis; 
        int [] ocorrencias= new int[60]; // se encontrar uma ocorrencia de um numero adiciona um naquela posicao
        int sorteio,contador=0,numero=0;
        int [] v = new int [6];
        try {
        
            sc = new Scanner(new File(nomeArquivo));
        } catch (FileNotFoundException ex) {
            System.err.println("Nao foi possível abrir o arquivo!");
        }
        
        
        while(sc.hasNext()){
            sorteio= sc.nextInt();
            for(int i=0;i<6;i++){
                numero= sc.nextInt();
                ocorrencias[numero]= ocorrencias[numero]+1;
            }    
        }
        
        for(int k=0;k<60;k++){
            System.out.printf("\n %d",ocorrencias[k]);
        }
        sc.close();
        
    }
    
   
    
    
  


    
}

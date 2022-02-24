import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ejercicio1 {

    public static Scanner sc = new Scanner(System.in);
    public static List<Integer> barrio = new ArrayList();
    public static List<Integer> barrioTmp = new ArrayList();


    public static void main(String[] args) {

        int indice=0;
        for (int i = 0; i < 8; i++) {
            System.out.println("Ingrese el estado de la casa #"+(i+1));
            barrio.add(Integer.parseInt(sc.nextLine()));
        }

        System.out.println("Cantidad de días");
        int day=Integer.parseInt(sc.nextLine());
        for (int i = 0; i < day  ; i++) {
            start();
        }

    }

    public static void start(){
        for (int i = 0; i < barrio.size(); i++) {
            validateState(i);
        }

        cloneArray();
        System.out.println(barrio.toString());
    }

    public static void validateState(int indice){
        if(indice==0){
            if(barrio.get(indice+1)==0){
                barrioTmp.add(0);
                return;
            }
            barrioTmp.add(1);
            return;
        }
        if(indice==7){
            if(barrio.get(indice-1)==0){
                barrioTmp.add(0);
                return;
            }
            barrioTmp.add(1);
            return;
        }

        if (barrio.get(indice-1)==barrio.get(indice+1)){
            barrioTmp.add(0);
            return;
        }
        barrioTmp.add(1);
    }

    public static void cloneArray(){
        barrio.clear();
        barrio = (List<Integer>) barrioTmp.stream().collect(Collectors.toList());
        barrioTmp.clear();
    }

}

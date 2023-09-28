import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Manager> managers = new ArrayList<>();
        ArrayList<Zadacha> zadachas = new ArrayList<>();
        String comanda = "";
        String status="";
        int IDMAN = 0;
        int IDZadach=0;
        int IDM = 0;
        String FIO="";
        String FIO2="";
        String naim="";
        String comment = "";
        while (true) {
            System.out.println("Введите команду 'Добавить менеджера' или 'Добавить задачу' или 'Переназначить исполнителя задачи' или 'Выйти'");
            comanda=scanner.nextLine();
            if (comanda.equals("Добавить менеджера")) {
            FIO = scanner.nextLine();
            Manager manager = new Manager(FIO,IDMAN);
            managers.add(manager);
            for(int i=0;i< managers.size();i++){
                System.out.println("ID: "+managers.get(i).ID+"; ФИО: "+managers.get(i).FIO+".");
            }
            IDMAN++;
            }
            if (comanda.equals("Добавить задачу")){
                naim = scanner.nextLine();
                comment=scanner.nextLine();
                status=scanner.nextLine();
                FIO=scanner.nextLine();
                for(int i=0;i< managers.size();i++){
                    if(managers.get(i).FIO.equals(FIO)){
                        IDM=managers.get(i).ID;
                    }
                }
                Zadacha zadacha = new Zadacha(naim,comment,status,IDZadach,IDM);
                zadachas.add(zadacha);
                IDZadach++;
                for(int i=0;i< zadachas.size();i++){
                    for(int j=0;j< managers.size();j++){
                        if(managers.get(j).FIO.equals(FIO)){
                            IDM=managers.get(j).ID;
                        }
                    }
                    System.out.println("ID: "+zadachas.get(i).ID+"; Наименование: "+zadachas.get(i).naim+"; Комментарий: "+zadachas.get(i).comment+"; Ответственный: " +FIO+"; Статус: "+zadachas.get(i).status);
                }
            }
            if(comanda.equals("Переназначить исполнителя задачи")){
                naim=scanner.nextLine();
                for(int j=0;j< zadachas.size();j++){
                    if(zadachas.get(j).naim.equals(naim)){
                        IDZadach=zadachas.get(j).ID;
                    }
                }
                FIO=scanner.nextLine();
                for(int j=0;j< managers.size();j++){
                    if(managers.get(j).FIO.equals(FIO)){
                        IDMAN=managers.get(j).ID;
                    }
                }
                    zadachas.get(IDZadach).IDispoln=IDMAN;
                for(int i=0;i< zadachas.size();i++){
                    for(int j=0;j< managers.size();j++){
                        if(managers.get(j).FIO.equals(FIO)){
                            IDM=managers.get(j).ID;
                        }
                    }
                    System.out.println("ID: "+zadachas.get(i).ID+"; Наименование: "+zadachas.get(i).naim+"; Комментарий: "+zadachas.get(i).comment+"; Ответственный: " +FIO+".");
                }
                }

            if(comanda.equals("Выйти")){
                break;
            }
        }
    }
}
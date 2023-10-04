package Program;
import java.util.*;
import Entity.ManufactureEntity;
import Entity.PhoneEntity;
import Controler.*;
public class Program {

    private manufactureDAO<ManufactureEntity> manufactureDAO;
    private phoneDAO<PhoneEntity> phoneDAO;

    public Program() {
        manufactureDAO = new manufactureDAO<>();
        phoneDAO = new phoneDAO<>();
    }

    private void add_Manufacture() {
        System.out.println("Enter the inf of a new manufacture");
        System.out.print(("Enter a manufacture id: "));
        Scanner sc = new Scanner(System.in);
        String id = sc.nextLine();
        //sc.nextLine();
        System.out.print("Enter name manufacture: ");
        String name = sc.nextLine();
        System.out.print("Enter location: ");
        String location = sc.nextLine();
        System.out.print("Enter number of employee: ");
        int employee = sc.nextInt();
        manufactureDAO.add(new ManufactureEntity(id, name, location, employee));
        System.out.println("Successfully to added Manufacture has id: " + id);

    }

    private void getManufactureById() {
        System.out.print("Enter the manufacture id to search: ");
        Scanner sc = new Scanner(System.in);
        String id = sc.nextLine();
        ManufactureEntity manu = manufactureDAO.get(id);
        if (manu == null) {
            System.out.println("Manufacture with id: '" + id + "' does not exists");
        } else {
            System.out.println("Successfully found the manufacture with id: " + id + "\n" + manu);
        }

    }

    private void getAllManufacture() {
        List<ManufactureEntity> manufactureList = manufactureDAO.getAll();
        manufactureList.forEach(System.out::println);
    }

    private void updateManufacture() {
        System.out.print("Enter the manufacture id for which you want to update information: ");
        Scanner sc = new Scanner(System.in);
        String id = sc.nextLine();
        //sc.nextLine(); // Lay ki tu enter o dong scanner ben tren
        System.out.print("Enter the name of manufacture you want to update: ");
        String name = sc.nextLine();
        System.out.print("Enter the manufacture location you want to update: ");
        String location = sc.nextLine();
        System.out.print("Enter the manufacture employees you want to update: ");
        int employees = sc.nextInt();
        try {
            System.out.println(manufactureDAO.update(new ManufactureEntity(id, name, location, employees)));
            if (manufactureDAO.update(new ManufactureEntity(id, name, location, employees))) {
                System.out.println("Successfully updated manufacture with id: " + id);
            } else {
                System.out.println("Update failed Manufacture with id: '" + id + "' does not exists");
            }
        } catch (Exception e) {
            e.getMessage();
        }

    }

    private void deleteManufactureById() {
        System.out.print("Enter the manufacture id to remove: ");
        Scanner sc = new Scanner(System.in);
        String id = sc.nextLine();
        if (manufactureDAO.remove(id)) {
            System.out.println("Successfully remove the manufacture with id: " + id);

        } else {
            System.out.println("Manufacture with id: '" + id + "' does not exists");
        }
    }

    private void showManufactureHaveMoreThan100Employess() {
        List<ManufactureEntity> manufactureList = manufactureDAO.getAll();
        System.out.println("Manufacture have more than 100 employees:");
        for (ManufactureEntity m : manufactureList) {
                if(manufactureDAO.checkAllManufactureHaveMoreThan100Employee(m)){
                    System.out.println(m);
                }
        }
    }

    private void sumOfEmployees(){
        System.out.println("Sum of all employees of the manufactures: " + manufactureDAO.sumOfAllEmployeesOfTheManufacture());
    }
    private void getLastManufactureBasedInUS(){
        ManufactureEntity manufacture = manufactureDAO.manufactureAtUS();
        System.out.println("The last manufacture based in US in list: " + manufacture);
    }

    private void insertDataManufactureIntoDB() {
        manufactureDAO.insertvalues();
    }

    //---------------------------------- Phone Program -----------------------------------------//
    private void add_Phone() {
        System.out.println("Enter the inf of a new Phone");
        System.out.print(("Enter a Phone id: "));
        Scanner sc = new Scanner(System.in);
        String id = sc.nextLine();
        //sc.nextLine();
        System.out.print("Enter Phone name: ");
        String name = sc.nextLine();
        System.out.print("Enter price: ");
        int price = sc.nextInt();
        sc.nextLine(); // Lay ki tu enter con thua o dong input tren
        System.out.print("Enter color: ");
        String color = sc.nextLine();
        System.out.print("Enter country: ");
        String country = sc.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter id manufacture that owns the phone: ");
        String id_manufacture = sc.nextLine();
        if (phoneDAO.add(new PhoneEntity(id, id_manufacture, name, price, color, country, quantity))) {
            System.out.println("Successfully to added new Phone has id: " + id);
        } else {
            System.out.println("Added failed, invalid information");
        }
    }

    private void getPhoneById() {
        System.out.print("Enter the phone id to get: ");
        Scanner sc = new Scanner(System.in);
        String id = sc.nextLine();
        PhoneEntity phone = phoneDAO.get(id);
        if (phone == null) {
            System.out.println("Phone with id: '" + id + "' does not exists");
        } else {
            System.out.println("Successfully found the Phone with id: " + id + "\n" + phone);
        }
    }

    private void getAllPhone() {
        List<PhoneEntity> phoneList = phoneDAO.getAll();
        phoneList.forEach(System.out::println);
    }

    private void updatePhone() {
        System.out.print("Enter the phone id for which you want to update information: ");
        Scanner sc = new Scanner(System.in);
        String id = sc.nextLine();
        //sc.nextLine(); // Lay ki tu enter o dong scanner ben tren
        System.out.print("Enter the name of phone you want to update: ");
        String name = sc.nextLine();
        System.out.print("Enter the phone price you want to update: ");
        int price = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter the phone color you want to update: ");
        String color = sc.nextLine();
        System.out.print("Enter the phone country you want to update: ");
        String country = sc.nextLine();
        System.out.print("Enter the phone quantity you want to update: ");
        int quantity = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter the manufactue id that owns the phone: ");
        String manufactureId = sc.nextLine();
        try {
            if (phoneDAO.update(new PhoneEntity(id, manufactureId, name, price, color, country, quantity))) {
                System.out.println("Successfully updated phone with id: " + id);
            } else {
                System.out.println("Update failed phone with id: '" + id + "' does not exists");
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    private void deletePhoneById() {
        System.out.print("Enter the phone id to remove: ");
        Scanner sc = new Scanner(System.in);
        String id = sc.nextLine();
        if (phoneDAO.remove(id)) {
            System.out.println("Successfully remove the phone with id: " + id);

        } else {
            System.out.println("Phone with id: '" + id + "' does not exists");
        }
    }
        private void getHighestPhonePrice(){
            System.out.println("The phone has highest price is: " + phoneDAO.highestPhonePrice());
        }
        private void getListOrderByCountry(){
            for(PhoneEntity p : phoneDAO.orderByCountryAndPriceDESC()){
                System.out.println(p);
            }
        }
        private void getListPhonehasPriceAbove50(){
            List<PhoneEntity> phoneList = phoneDAO.getAll();
            List<PhoneEntity> phone_Show = new ArrayList<>();
            int count = 0 ;
            for(PhoneEntity p : phoneList){
                if(phoneDAO.checkPriceAbove50(p)){
                    phone_Show.add(count, p);
                    count++;
                }
            }
            System.out.println("There are " + count + " phones priced at over 50 million VND");
            for(PhoneEntity p : phone_Show){
                System.out.println(p);
            }
        }

            private void getFirstPhoneColorAndPrice(){
            System.out.println(phoneDAO.getFirstPhoneHasPinkColorAndAbove15());
        }
        private void insertPhoneDataIntoDB(){phoneDAO.insertvalues();}
    // ------------- Program --------------//
    private void showMenu() {
        System.out.println("1. Read all Manufacture");
        System.out.println("2. Read a Manufacture by id");
        System.out.println("3. Add a new manufacture");
        System.out.println("4. Update a manufacture");
        System.out.println("5. Delete a manufacture by id");
        System.out.println("6. Show all manufacture have more than 100 employees");
        System.out.println("7. Sum of all employees of the manufactures");
        System.out.println("8. Show the last manufacture based in US");
        System.out.println("9. Read all Phone");
        System.out.println("10. Read a phone by id");
        System.out.println("11. Add a new phone");
        System.out.println("12. Update a phone");
        System.out.println("13. Delete a phone by id");
        System.out.println("14. Get highest phone price");
        System.out.println("15. Get a list of phones sorted by country name, sort descending by price");
        System.out.println("16. Phone priced above 50 million VND");
        System.out.println("17. First phone in the list that meets the criteria: has the color 'Pink' and costs over 15 million.");

        System.out.println("18. Exit");
        System.out.print("Your choice: ");
    }

    public static void main(String[] args) {
        Program program = new Program();
        program.insertDataManufactureIntoDB();
        program.insertPhoneDataIntoDB();
        int optional = 0;
        while (optional != -1) {
            program.showMenu();
            Scanner sc = new Scanner(System.in);
            optional = sc.nextInt();
            switch (optional) {
                case 1:
                    program.getAllManufacture();
                    break;
                case 2:
                    program.getManufactureById();
                    break;
                case 3:
                    program.add_Manufacture();
                    break;
                case 4:
                    program.updateManufacture();
                    break;
                case 5:
                    program.deleteManufactureById();
                    break;
                case 6:
                    program.showManufactureHaveMoreThan100Employess();
                    break;
                case 7:
                    program.sumOfEmployees();
                    break;
                case 8:
                    program.getLastManufactureBasedInUS();
                    break;
                case 9:
                    program.getAllPhone();
                    break;
                case 10:
                    program.getPhoneById();
                    break;
                case 11:
                    program.add_Phone();
                    break;
                case 12:
                    program.updatePhone();
                    break;
                case 13:
                    program.deletePhoneById();
                    break;
                case 14:
                    program.getHighestPhonePrice();
                    break;
                case 15:
                    program.getListOrderByCountry();
                    break;
                case 16:
                    program.getListPhonehasPriceAbove50();
                    break;
                case 17:
                    program.getFirstPhoneColorAndPrice();
                    break;
                case 18:
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}



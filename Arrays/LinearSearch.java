

public class Main {
    //Time Complexity -> O(n)
    //Since we run this program n times searching for every element in array 
    public static void main(String[] args) {

        String [] menu = {"Burger","Pizza","Pasta","Momos"};
        String item = "Momos";
        int index = linearSearch(menu,item);

        if(index==-1){
            System.out.println("Item is not present in the menu");
        }else{
            System.out.println("Item is present at index " +index);
        }
    }

    public static int linearSearch(String [] menu,String item){

        for(int i=0;i<menu.length;i++){
            if(menu[i].equals(item)){
                return i;
            }
        }
        return -1;
    }
}

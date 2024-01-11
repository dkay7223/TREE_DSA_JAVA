import java.util.Scanner;

public class Main {

    public static int getMainMenuSelection() {
        System.out.println();
        System.out.println("=======MAIN MENU=======");
        System.out.println("==  1. Insert          =");
        System.out.println("==  2. Delete          =");
        System.out.println("==  3. Search          =");
        System.out.println("==  4. Print Inorder   =");
        System.out.println("==  5. Print PreOrder  =");
        System.out.println("==  6. Print PostOrder =");
        System.out.println("==  7. Print Diagram   =");
        System.out.println("==  0. Exit            =");
        System.out.println("   Select Option : ");
        System.out.println();

        Scanner input = new Scanner(System.in);
        int select = input.nextInt();

        if (select == 1) {
            return 1;
        }
        if (select == 2) {
            return 2;
        }
        if (select == 3) {
            return 3;
        }
        if (select == 4) {
            return 4;
        }
        if (select == 5) {
            return 5;
        }
        if (select == 6) {
            return 6;
        }
        if (select == 7) {
            return 7;
        }

        return 0;
    }


    public static void main(String[] args){

        AVLDictionary dictionary=Serialization.read();

        System.out.println(dictionary.height(dictionary.root));
        Scanner input = new Scanner(System.in);
        int option;

        while ((option = getMainMenuSelection()) != 0) {
            switch (option) {

                case 1 :{
                    System.out.println("Input New Word : ");
                    String spell=input.next();
                    input.nextLine();
                    System.out.println("Input its Meaning : ");
                    String meaning= input.nextLine();

                    Word w=new Word(spell,meaning);

                    dictionary.insert(w);

                    System.out.println("New Word Added in the Dictionary");

                    break;
                }

                case 2 :{

                    System.out.println("Input Word to Delete : ");
                    String spell=input.next();
                    dictionary.delete(spell);

                    break;
                }

                case 3 :{

                    System.out.println("Input Word to Search : ");
                    String spell=input.next();
                    System.out.println(dictionary.Search(spell));

                    break;
                }
                case 4 :{
                    System.out.println("========INORDER======");
                    dictionary.printInorder(dictionary.root);

                    break;
                }
                case 5 :{

                    System.out.println("========PREORDER======");
                    dictionary.printPreorder(dictionary.root);

                    break;
                }
                case 6 :{

                    System.out.println("========POSTORDER======");
                    dictionary.printPostorder(dictionary.root);

                    break;
                }

                case 7:{

                    dictionary.printTree(dictionary.root, "",true);
                    break;

                }

                default:
                    throw new IllegalStateException("Unexpected value: " + option);
            }
        }

/*        Word a=new Word("Usman","Happy");
        Word b=new Word("Tayyba","Happy");
        Word c=new Word("Mahad","Happy");
        Word d=new Word("Dani","Happy");
        Word e=new Word("Abdullah","Happy");
        Word f=new Word("Khajja","Happy");
        Word g=new Word("Ayesha","Happy");
        Word h=new Word("ABMalik","Happy");

        dictionary.insert(a);
        dictionary.insert(b);
        dictionary.insert(c);
        dictionary.insert(d);
        dictionary.insert(e);
        dictionary.insert(f);
        dictionary.insert(g);
        dictionary.insert(h);*/

        //System.out.println(dictionary.getBalance(dictionary.root));
        //System.out.println(dictionary.height(dictionary.root));
        //dictionary.printTree(dictionary.root, " ",true);
//dictionary.print(dictionary.root);
       /* System.out.println(dictionary.getBalance(dictionary.root));
        System.out.println(dictionary.height(dictionary.root));
      dictionary.delete("Mahad");

        System.out.println(dictionary.height(dictionary.root));

       // System.out.println(dictionary.Search("Mahad"));



       // System.out.println(dictionary.getBalance(dictionary.root));
      //  System.out.println(dictionary.height(dictionary.root));*/

        System.out.println(dictionary.root.data.getSpell());
        dictionary.printTree(dictionary.root, " ",true);





    }
}

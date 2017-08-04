import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class TracingGenealogies {
    public static void main(String[] args)
    {
       File fileDir = new File ("/Users/victorsamperio/Documents/workspace/");
       String filePath = search(fileDir, "family.txt");
       if(filePath == null )
    	   System.out.println("File Not found");
       else {
    	   File file = new File ("family.txt");
    	   FamilyTree<String> tree;
    	   Scanner keyboard = new Scanner(System.in);
    	   String parent;
    	   String kid;
    	   try {
    		   tree = loadTree(file);
    		  // System.out.println(tree);
    		   System.out.print("Enter parent name: ");
    		   parent = keyboard.nextLine();
    		   System.out.print("Enter child name: ");
    		   kid = keyboard.nextLine();
    		   //System.out.println("\n" + parent + "\n" + kid) ;
    		   if (isDescendant(kid, parent, tree)){
    			   //System.out.println("It might work");
    			   System.out.println(getTrace(kid, parent, tree, kid));
    		   } else 
    			   System.out.println(kid + " is not a descendant of " + parent + ".");
    	   } catch (Exception e){
    		   System.out.println("Error : " + e);
    	   }
    	   keyboard.close();
       }
    }
    static String search(File inDir, String searchFileName){
    	Queue<File> directoriesToSearch = new LinkedList<File>();
    	directoriesToSearch.add(inDir);
    	while (!directoriesToSearch.isEmpty()){
    		//get next directory
			File currDir = directoriesToSearch.remove();
			//get contents of current directory 
			String[] dirContents = currDir.list();
			//directory contents will be null if there is 
			//a problem listing the directory contents 
			if (dirContents == null) continue;
			//do the directory contents contain the desire file?
			if(Arrays.asList(dirContents).contains(searchFileName)){
				return currDir.getAbsolutePath();
			}
			//Desired file not in the current directory
			//add all the children of this directory to the 
			//queue of directories to be searched
			File[] childDirectories = currDir.listFiles();
			for ( File f : childDirectories){
				if (f.isDirectory())
					directoriesToSearch.add(f);
			}
			
    	}
    	//no more directories left to search so not found
		return null;
    	
    }

    private static FamilyTree<String> loadTree(File file) throws FileNotFoundException
    {
    	Scanner scan = new Scanner(file);
        FamilyTree<String> tree;

        int entries = Integer.parseInt(scan.nextLine());
       // System.out.println(entries);
        // Initial setup of tree
        {
            String line = scan.nextLine();
            //System.out.println(line);
            String[] words = getWords(line);
            //for (String a : words){System.out.print(a + " ");} 
            tree = new FamilyTree<String>(words[0]);

            for(int i = 1; i < words.length; i++)
            {
                tree.addNode(words[i]);
            }
        }

        for(int i = 1; i < entries; i++)
        {
            String line = scan.nextLine();
            String[] words = getWords(line);

            FamilyTree<String> person = tree.getTree(words[0]);

            for(int j = 1; j < words.length; j++)
            {
                person.addNode(words[j]);
            }
        }
        scan.close();
        return tree;
    }

    private static String[] getWords(String line)
    {
        return line.split("\\  *[\\d*]?[  *]?\\s*");
    }

    private static boolean isDescendant(String kid, String target, FamilyTree<String> tree)// throws NullPointerException
    {
        FamilyTree<String> childTree = tree.getTree(kid);
        FamilyTree<String> parentTree = tree.getTree(target);
        //System.out.println(childTree + "\n" + parentTree);
        //System.out.print(childTree.getHead() + "  " + parentTree.getHead());
        if (childTree == null || parentTree == null ){ 
        	return false;
        }
        else 
        	return parentTree.getTree(childTree.getHead()) == null ? false : true;
    }


	private static String getTrace(String kid, String target, FamilyTree<String> tree, String lineage)
    {
        FamilyTree<String> childTree = tree.getTree(kid);
        FamilyTree<String> parentTree = childTree.getParent();

        if(!parentTree.getHead().equals(target))
        {	
            return getTrace(parentTree.getHead(), target, tree, lineage + " -> " + parentTree.getHead());
        }
        else
        {
            return lineage + " -> " + parentTree.getHead();
        }
    }
}



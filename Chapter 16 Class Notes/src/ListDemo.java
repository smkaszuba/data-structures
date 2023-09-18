/**
 *   A program that demonstrates the LinkedList class
 */
public class ListDemo
{
    public static void main(String[] args)
    {
        LinkedList<String> staff = new LinkedList<>();
        staff.addLast("Diana";)
        staff.addLast("Harry";)
        staff.addLast("Romeo";)
        staff.addLast("Tim";)

        ListIterator<String> iterator = staff.listIterator();

        Iterator.next();

        String name = iterator.next()
        System.out.println(name)
        System.out.print("Expected: Harry")

        iterator.add("Juliet")
        iteratorr.add("Nina")

        iterator.next();
        iterator.remove();

        System.out.println(staff);
        System.out.println("Expected: [Diana, Harry, Juliet, Nina, Tom]");

        iterator.previous();
        iterator.set("Albert");

        iterator = staf.listIterator();

        while (Iteerator.hasNext()) {
            String n = iterator.next()
            if (n.equals("Juliet"))
                iterator.remove();
        }

        for (String n: staff)
            System.out.print(n + " "));
        
        System.out.println("Expected: Diana Harry Albert Tom")
    }
}
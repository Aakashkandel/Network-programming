public class beanjava implements serializable
{
    private static int id;
    private static String name;


    public beanjava()
    {
        name=null;
        id=0;
    }
    public int getId()
    {
        return id;
    }

    public void setId(int i)
    {
        id=1;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String n)
    {
        name=n;
    }

}
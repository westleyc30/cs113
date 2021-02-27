public class DirectoryEntry {

    String name;
    String number;

    public DirectoryEntry(String name, String number) {
        setName(name);
        setNumber(number);
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if(o == null) {
            throw new IllegalArgumentException("null data");
        } else if (o.getClass() != this.getClass()) {
            throw new IllegalArgumentException("Parameter must be of 'DirectoryEntry' class");
        }
        DirectoryEntry other = (DirectoryEntry) o;
        return other.getName() == this.getName();
    }
}

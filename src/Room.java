public  class Room {
    protected int bedroom;
    protected int toilet;
    protected int floor;

    public Room(){
        this.bedroom = 0;
        this.toilet = 0;
        this.floor = 0;
    }
    public Room(int bedroom){
        this.bedroom = bedroom;
        this.toilet = 0;
        this.floor = 0;
    }
    public Room(int bedroom , int toilet){
        this.bedroom = bedroom;
        this.toilet = toilet;
        this.floor = 0;
    }
    public Room(int bedroom,int toilet,int floor){
        this.bedroom = bedroom;
        this.toilet = toilet;
        this.floor = floor;
    }
    public int getBedroom(){
        return bedroom;
    }
    public void setBedroom(int bedroom){
        this.bedroom = bedroom;
    }
    public int getToilet(){
        return toilet;
    }
    public void setToilet(int toilet){
        this.toilet = toilet;
    }
    public int getFloor(){
        return floor;
    }
    public void setFloor(int floor){
        this.floor = floor;
    }
    static class Lowfloor extends Room
    {
        public Lowfloor()
        {
            super();
        }
        public Lowfloor(int bedroom)
        {
            super(bedroom);
        }
        public Lowfloor(int bedroom,int toilet)
        {
            super(bedroom, toilet);
        }
        public Lowfloor(int bedroom, int toilet, int floor)
        {
            super(bedroom, toilet, floor);
        }

    }
    static class Mediumfloor extends Room
    {
        public Mediumfloor()
        {
            super();
        }
        public Mediumfloor(int bedroom)
        {
            super(bedroom);
        }
        public Mediumfloor(int bedroom,int toilet)
        {
            super(bedroom, toilet);
        }
        public Mediumfloor(int bedroom, int toilet, int floor)
        {
            super(bedroom, toilet, floor);
        }

    }
    static class Highfloor extends Room
    {
        public Highfloor()
        {
            super();
        }
        public Highfloor(int bedroom)
        {
            super(bedroom);
        }
        public Highfloor(int bedroom,int toilet)
        {
            super(bedroom, toilet);
        }
        public Highfloor(int bedroom, int toilet, int floor)
        {
            super(bedroom, toilet, floor);
        }
    }

}

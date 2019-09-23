/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
class User {
    private int shopid,phonenumber,floor;
    private String shopname,category,sales,timings;
    
    public User(int shopid,String shopname,String category,int phonenumber,int floor,String sales,String timings)
    {
        this.shopid=shopid;
        this.shopname=shopname;
        this.category=category;
        this.phonenumber=phonenumber;
        this.floor=floor;
        this.sales=sales;
        this.timings=timings;
    }
    public int getshopid(){
        return shopid;
        
    }
    public String getshopname(){
        return shopname;
        
    }
    public String getcategory(){
        return category;
        
    }
    public int getphonenumber(){
        return phonenumber;
        
    }
    public int getfloor(){
        return floor;
        
    }
    public String getsales(){
        return sales;
        
    }
    public String gettimings(){
        return timings;
        
    }

    
}

package com.example.vybecosapp.Model;

public class DataAluminiumFoil {
   Integer ID;
   String Name;
   String SubName;
   String Rate;
   Integer Image;

   public String getName() {
      return Name;
   }

   public void setName(String name) {
      Name = name;
   }

   public String getSubName() {
      return SubName;
   }

   public void setSubName(String subName) {
      SubName = subName;
   }

   public String getRate() {
      return Rate;
   }

   public void setRate(String rate) {
      Rate = rate;
   }

   public Integer getImage() {
      return Image;
   }

   public void setImage(Integer image) {
      Image = image;
   }

   public Integer getID() {
      return ID;
   }

   public void setID(Integer ID) {
      this.ID = ID;
   }

   public DataAluminiumFoil(Integer ID , String Name, String SubName , String Rate, Integer image) {
      this.ID = ID;
      this.Name = Name;
      this.SubName = SubName;
      this.Rate = Rate;
      this.Image = image;
   }
}
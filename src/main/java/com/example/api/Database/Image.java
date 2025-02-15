package com.example.api.Database;

public class Image {
   
    private String filename;
    private int filesize;
    private String sha256value;
    private byte[] filedata;
    
    public Image(String filename){
        this.filename = filename;
    }
    
    public Image(String filename, int filesize){
        this.filename = filename;
        this.filesize = filesize;
    }

    public Image(String filename, byte[] filedata, int filesize){
        this.filename = filename;
        this.filedata = filedata;
        this.filesize = filesize;
    } 

    public void setFilename(String filename){
        this.filename = filename;
    }

    public String getFilename(){
        return this.filename;
    }

    public void setFilesize(int filesize){
        this.filesize = filesize;
    }

    public void setFiledata(byte[] filedata){
        this.filedata = filedata;
    } 

    public byte[] getFiledata(){
        return this.filedata;
    }

    public int getFilesize(){
        return this.filesize;
    }
    //implement this
    public void setSha256value(){

    }
    
    public String getSha256value(){
        return this.sha256value;
    }
}

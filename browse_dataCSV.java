class browse_dataCSV{

BufferedReader br=new BufferedReader(new FileReader("data.csv"));
    String line;
    String[] data = null;

    while((line=br.readLine())!=null){
        data = line.split(",");
    }

    String[] unames = new String[data.length/2];   
    String[] fnames = new String[data.length/2];

    for(int i=0; i <= (data.length/2)-1; i++){
        unames[i] = data[i];
    }
    
    for(int i=data.length/2, j=0; i <= data.length-1; i++, j++){
        fnames[j] = data[i];
    }


}
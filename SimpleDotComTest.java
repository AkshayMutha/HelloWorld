import java.io.*;
public class SimpleDotComTest{
public static void main(String[] args){

int numberOfGuesses= 0;
GameHelper helper = new GameHelper();
SimpleDotCom theDotCom = new SimpleDotCom();
int randomnum = (int)Math.random()*4;
int[] locations = {randomnum, randomnum+1,randomnum+2};
theDotCom.setlocationCells(locations);
    boolean isAlive= true;
    
    while (isAlive = true){
        String inputguess = helper.getUserInput("enter a number");
        String result = theDotCom.checkYourself(inputguess);
        numberOfGuesses++;
        if(result.equals("kill")){
            isAlive = false;
            System.out.println("the number og guess you took is:" +numberOfGuesses);
        }
    }
}
}
class SimpleDotCom{
private int[] locationCells;
private int numOfHits = 0;

public void setlocationCells(int[] location){
locationCells = location;
}
public String checkYourself(String guess){
int userguess= Integer.parseInt(guess);
String result = "miss";
for(int cell : locationCells){
if (userguess == cell){
result = "hit";
numOfHits++;
break;
}
}
if(numOfHits==locationCells.length){
result = "kill";
}
System.out.println(result);
return result;
}
}
class GameHelper{
    public String getUserInput(String prompt){
        String inputLine = null;
        System.out.print(prompt + " ");
        try{
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if(inputLine.length()==0) return null;
        }catch (IOException e){
            System.out.println("IOException: " +e);
        }
        return inputLine;
    }
}
<table><tr><td> <em>Assignment: </em> IT114 Trivia Milestone 2</td></tr>
<tr><td> <em>Student: </em> Romer Rodriguez (rr268)</td></tr>
<tr><td> <em>Generated: </em> 11/15/2023 9:42:11 PM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-003-F23/it114-trivia-milestone-2/grade/rr268" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <p>Implement the features from Milestone2 from the proposal document:&nbsp;<a href="https://docs.google.com/document/d/1h2aEWUoZ-etpz1CRl-StaWbZTjkd9BDMq0b6TXK4utI/view">https://docs.google.com/document/d/1h2aEWUoZ-etpz1CRl-StaWbZTjkd9BDMq0b6TXK4utI/view</a></p>
</td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Payload </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Payload Screenshots</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Frr268%2F2023-11-15T15.55.20Screenshot_409.png.webp?alt=media&token=723de0b6-4b96-4155-b404-e5d2af83aca2"/></td></tr>
<tr><td> <em>Caption:</em> <p>This shows my payload code in which I add to it set and<br>get function for both scores and answers which are data that I wanted<br>to be stored inside of the payload.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Frr268%2F2023-11-15T15.57.40Screenshot_410.png.webp?alt=media&token=a51f1ca1-3c1d-494c-98ee-3037702cea5a"/></td></tr>
<tr><td> <em>Caption:</em> <p>Screenshot of an answer being given from client storing the users score.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Frr268%2F2023-11-15T16.19.44Screenshot_411.png.webp?alt=media&token=36ce7f4b-a4ff-4cf6-b94e-6d3c26563006"/></td></tr>
<tr><td> <em>Caption:</em> <p>Screenshot of the user getting their score back from the serverthread<br></p>
</td></tr>
</table></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Game Play Code </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Show the code related to the question/category choice</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Frr268%2F2023-11-15T16.21.36Screenshot_412.png.webp?alt=media&token=aa576299-eb91-447e-9aa0-5711267e6d33"/></td></tr>
<tr><td> <em>Caption:</em> <p>List of categories and questions, for now they are all in the same<br>file since it is small, but in the future when I add more<br>questions I will seperate into different folders the questions by category.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Frr268%2F2023-11-15T16.35.07Screenshot_414.png.webp?alt=media&token=a77d9f68-714f-4f50-8f90-04003c351600"/></td></tr>
<tr><td> <em>Caption:</em> <p>The for this code is to create an Arraylist of integers that will<br>serve as the question number that will be selected but shuffling the arraylist<br>then grabbing the first 3 questions in the arraylist and processing them through<br>the trivia function that will print the question out. (as of now there<br>is no logic for randomly selecting category but it would be similar to<br>questions but instead there will be another array that store the different categories<br>into an array on of the files will be selected randomly and then<br>a questions inside will then get randomly selected by the same method as<br>before.)<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Frr268%2F2023-11-15T16.44.36Screenshot_415.png.webp?alt=media&token=56ebe034-25ca-49a2-b1ee-71797b1df7f2"/></td></tr>
<tr><td> <em>Caption:</em> <p>This piece of code takes in the int quesNum as a parameter which<br>is the first index of quesitionNum array list from before that num is<br>used as a index to find the line where the random question is<br>stored. All the lines of the questions txt file is read and stored<br>into a arraylist strings then using the quesLine index it reads that index<br>of that string in a for loop and  the next 4 lines<br>until the 4 line which contains the correct answer this is the only<br>line that is only read and stored instead of read and printed out.<br>This is all in a try catch block to prevent IO exception from<br>messing things up.<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Show the code related to players picking answers</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Frr268%2F2023-11-15T16.52.01Screenshot_416.png.webp?alt=media&token=0c2bac7a-1cd5-4cff-8384-5e5277b7e7a1"/></td></tr>
<tr><td> <em>Caption:</em> <p>For now it is a command that takes out the /answer part trims<br>it and sends the answer to be processed as a payload.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Frr268%2F2023-11-16T01.59.54Screenshot_430.png.webp?alt=media&token=58e388b8-ee3c-425b-b809-7806ea80bc12"/></td></tr>
<tr><td> <em>Caption:</em> <p>It computes score by looking at each index of the answerOrder list and<br>finds who is in first spot and awards them the most points will<br>those in later spots get less points then the first.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Frr268%2F2023-11-16T02.20.59Screenshot_432.png.webp?alt=media&token=41b62780-456b-4cce-b767-37ca3dcf3244"/></td></tr>
<tr><td> <em>Caption:</em> <p>This code shows how when the /answer command is done it takes the<br>payload and checks the answer from that player regardless if it is correct<br>or not the boolean value of hasAnswered will be set to true and<br>they cant answer again. In the if(numAnswered &gt;= player.size()) condition checks if all<br>players answered and if they did it will calculate the score and go<br>to the next question<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Frr268%2F2023-11-16T02.26.18Screenshot_433.png.webp?alt=media&token=a8fc52be-e0f5-4316-add8-8f8e070b0c76"/></td></tr>
<tr><td> <em>Caption:</em> <p>This shows the how a timed event of 30 seconds is made and<br>if the 30 seconds run out it moves on to the next question<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Frr268%2F2023-11-16T02.28.08Screenshot_434.png.webp?alt=media&token=77307639-885e-42c3-8fb8-2745322e60ae"/></td></tr>
<tr><td> <em>Caption:</em> <p>this shows the making of the order for who has the most points<br>through making a ranking list of the scores organizing them from highest to<br>lowest then displaying who is the highest to lowest in score.<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Show the code related to the timer functionality</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Frr268%2F2023-11-16T02.29.28Screenshot_433.png.webp?alt=media&token=2666cbb6-8db9-4dba-8f6f-adec6ff0f535"/></td></tr>
<tr><td> <em>Caption:</em> <p>This shows how one timed event is made for 30 seconds and if<br>it expires it moves on to the next round <br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Frr268%2F2023-11-16T02.32.14Screenshot_435.png.webp?alt=media&token=620da30d-51d6-431c-8dbe-46271cc13d12"/></td></tr>
<tr><td> <em>Caption:</em> <p>This shows the next round occuring once all players have answered and canceling<br>the timed event to go to the next round.<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 4: </em> Explain the Game flow code at a high level</td></tr>
<tr><td> <em>Response:</em> <p>This game works by first having the players go through a ready check<br>once they are in a room. This would be done by doing /ready<br>for at least two players and once the minimum players required is checked<br>it starts the game function. The players are then introduced to the rules<br>of the game and how it works like using the command /answer &quot;their<br>answer&quot;. After rules are explained the player is given the first answer which<br>triggers a timed event to start the next questions and calculate score once<br>time runs out. Once the players answer or time runs out the game<br>computes the score in order of who answered first and outputs the players<br>scores and as well the order of who is in the top 3.<br>This repeats until all questions the game allows which is 3 for this<br>game as demo in which no more questions are given the sessions resets<br>and syncs all players to a non ready state in which they could<br>play again if they ready up once more.<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Game Evidence </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Show screenshots of the terminal output of a working game flow</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Frr268%2F2023-11-15T21.15.39Screenshot_426.png.webp?alt=media&token=7eb76fdd-ca7d-4730-8c55-6cf2a307dce9"/></td></tr>
<tr><td> <em>Caption:</em> <p>This shows the server sending a message to the room that the player<br>is getting <br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Frr268%2F2023-11-15T21.15.51Screenshot_427.png.webp?alt=media&token=7a80c5d1-7839-4c6c-8a9a-4666e6ef54c4"/></td></tr>
<tr><td> <em>Caption:</em> <p>this shows the player picking their answer through /answer and recieving points for<br>it.<br></p>
</td></tr>
</table></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 4: </em> Misc </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Include the pull request for Milestone2 to main</td></tr>
<tr><td> <a rel="noreferrer noopener" target="_blank" href="https://github.com/ChimmeyChunga/rr268-it114-003/pull/10">https://github.com/ChimmeyChunga/rr268-it114-003/pull/10</a> </td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-003-F23/it114-trivia-milestone-2/grade/rr268" target="_blank">Grading</a></td></tr></table>
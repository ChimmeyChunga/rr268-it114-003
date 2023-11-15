<table><tr><td> <em>Assignment: </em> IT114 Trivia Milestone 2</td></tr>
<tr><td> <em>Student: </em> Romer Rodriguez (rr268)</td></tr>
<tr><td> <em>Generated: </em> 11/15/2023 4:25:00 PM</td></tr>
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
<table><tr><td> <em>Deliverable 2: </em> Game Play Code </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707834-bf5a5b13-ec36-4597-9741-aa830c195be2.png"></td></tr>
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
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Frr268%2F2023-11-15T16.56.16Screenshot_417.png.webp?alt=media&token=79e0a635-7bef-412e-9547-7c68e7ea97a8"/></td></tr>
<tr><td> <em>Caption:</em> <p>This function is called once time runs out for the question the scored<br>in computed by going through the answerOrder array which stores the players in<br>order of which they answered. So the first index contains the player that<br>answer the fastest so they get the most points that is done by<br>finding the player in the players hashmap by clientid then setting their score<br>through a function built into the Player class.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Frr268%2F2023-11-15T17.00.47Screenshot_418.png.webp?alt=media&token=529acbea-7015-4a04-9688-7b9c8d53c4e4"/></td></tr>
<tr><td> <em>Caption:</em> <p>When everyone is ready it brings out the first question then it starts<br>a timed event that starts the second question after 30 seconds the fourth<br>questions after 60 and so on but for this iteration of the game<br>there is only 3 questions so once the time runs out the next<br>question is played the players score is computed and answerindex set to zero<br>so we can go through the answerOrder array from the beginning to get<br>the proper order.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Frr268%2F2023-11-15T19.42.52Screenshot_422.png.webp?alt=media&token=60524439-d8e4-4b34-a0b1-19168f0743c4"/></td></tr>
<tr><td> <em>Caption:</em> <p>So in order to get the order of players of players in the<br>lead the scores are stored into an array then sorted from largest to<br>smallest and then it goes through each player and finds which player has<br>the highest score and prints it out which should be the leader and<br>their score.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Frr268%2F2023-11-15T21.09.04Screenshot_424.png.webp?alt=media&token=761a5b8f-5657-4952-8c9d-dcfe176cd503"/></td></tr>
<tr><td> <em>Caption:</em> (missing)</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Frr268%2F2023-11-15T21.09.12Screenshot_425.png.webp?alt=media&token=77c37f4c-191a-4486-979a-b551231331d2"/></td></tr>
<tr><td> <em>Caption:</em> <p>So with these two screenshots I attempted at making logic where if both<br>players answered it would cancel all previous timed events run there callbacks and<br>then move on to the next question but it never ran properly and<br>gave an error whenever the second person would answer<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Show the code related to the timer functionality</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Frr268%2F2023-11-15T17.48.33Screenshot_418.png.webp?alt=media&token=7a5898ee-b32c-404e-b126-2ecd29ff28b9"/></td></tr>
<tr><td> <em>Caption:</em> <p>This shows different timed events being produced and each having a callback to<br>either compute the score, reset the answer order index, or going to the<br>next question after timer ticks to zero.<br></p>
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
<table><tr><td> <em>Deliverable 4: </em> Misc </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707795-a9c94a71-7871-4572-bfae-ad636f8f8474.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Include the pull request for Milestone2 to main</td></tr>
<tr><td>Not provided</td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-003-F23/it114-trivia-milestone-2/grade/rr268" target="_blank">Grading</a></td></tr></table>
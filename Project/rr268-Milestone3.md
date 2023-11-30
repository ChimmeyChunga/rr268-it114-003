<table><tr><td> <em>Assignment: </em> IT114 Trivia Milestone3</td></tr>
<tr><td> <em>Student: </em> Romer Rodriguez (rr268)</td></tr>
<tr><td> <em>Generated: </em> 11/29/2023 7:01:06 PM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-003-F23/it114-trivia-milestone3/grade/rr268" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <p>Implement the features from Milestone3 from the proposal document:&nbsp;<a href="https://docs.google.com/document/d/1h2aEWUoZ-etpz1CRl-StaWbZTjkd9BDMq0b6TXK4utI/view">https://docs.google.com/document/d/1h2aEWUoZ-etpz1CRl-StaWbZTjkd9BDMq0b6TXK4utI/view</a></p>
</td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Connection Screens </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshots showing the screens with the following data</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Frr268%2F2023-11-29T22.44.46Screenshot_442.png.webp?alt=media&token=c55c466c-b5f6-47ac-b09d-a60d09eddffd"/></td></tr>
<tr><td> <em>Caption:</em> <p>shows the host and port data being inputted<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Frr268%2F2023-11-29T22.44.58Screenshot_443.png.webp?alt=media&token=96788645-2be3-4398-8a78-412cd128f0f0"/></td></tr>
<tr><td> <em>Caption:</em> <p>shows the user name being inputted<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain the code for each step of the process</td></tr>
<tr><td> <em>Response:</em> <p><sup>So the program starts with asking the user to input both the port<br>and host then once that occurs it saves those until the next panel<br>which asks the user for its name. Once the user enters its name<br>its sets the users name to that name and&nbsp; it takes the previously<br>stored host and port and sends a connection payload to the server which<br>gets processed in the serverthread to create the lobby.</sup><br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Game view </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshots showing the related UI</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Frr268%2F2023-11-29T22.52.06Screenshot_445.png.webp?alt=media&token=5d969fb5-88b9-4029-bc6b-334c579cc53d"/></td></tr>
<tr><td> <em>Caption:</em> <p>shows list of users in the room on the right. As of this<br>update I couldn&#39;t get the userlist to display the score properly and also<br>attempted to make a timer using the timed event made from each round<br>and adding a tickcallback function to send a time to the UI and<br>update it with a timer of what is going on.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Frr268%2F2023-11-29T23.19.30Screenshot_446.png.webp?alt=media&token=9de39cfd-38e4-40e2-b145-26e716113e32"/></td></tr>
<tr><td> <em>Caption:</em> <p>In here you can see the game event history being previous points from<br>previous rounds what the question was and if the timer expired or not.<br>It also shows on the game panel in a bit of a disorganized<br>fashion but still there the category, questions, and answers in buttons. and depending<br>on if you got it right or not points are distributed.<br></p>
</td></tr>
</table></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Game Logic </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Show the code snippets for part of the game flow</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Frr268%2F2023-11-29T23.28.00Screenshot_450.png.webp?alt=media&token=4cd532da-e045-49c4-b17b-27cae202fef2"/></td></tr>
<tr><td> <em>Caption:</em> <p>So the game starts once the ready check is completed. Once that happens<br>the game makes sure every players data that is relevant to the game<br>is set properly which is setting their score to zero and making sure<br>a check to see if they have answered is false. Once is sets<br>everyone to a baseline to start the game it updates the phase to<br>a greeting for the players that they are about to play trivia game.<br>While that is occurring the game looks at the file where all the<br>questions are stored and checks to see how many are there so it<br>can shuffle the questions and categories. The actual shuffling of the questions take<br>place in bottom half this screenshot that was previously shown in milestone 2<br>where it creates an arraylist of question numbers and shuffles them where they<br>are sent to the beginning of the round function.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Frr268%2F2023-11-29T23.37.03Screenshot_451.png.webp?alt=media&token=f6d10458-701d-43ba-8a8c-8fbb3d81e776"/></td></tr>
<tr><td> <em>Caption:</em> <p>This is a where the code takes us next which is the round<br>method that starts off with an arraylist of all serverplayers to set certain<br>values for players and then a integer variable called winner set to 500<br>to check if the next round should occur or not and let the<br>game end. Now the code first goes through get player to see if<br>they have hit the required score of 500 or higher and ends game<br>if a player has reached that threshold once a player has reach that<br>threshold the game stops by setting the gameEnd variable to false which prevents<br>the round from beginning sets all the variables to their pre game values<br>updates the phase to end which will show the game being over in<br>the UI and announce the winner and resets the session. However if the<br>game has not reached a winner the game goes on by sending the<br>questionNum index of whatever question to the trivia function which will print out<br>the question. Then updates the game to a game phase and creates a<br>timedevent of 30 seconds for the player to answer which if the players<br>fails to both answer or timeout the scores are calculated next game phase<br>occurs and questions index goes up to get the next question in the<br>shuffle. <br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Frr268%2F2023-11-29T23.49.24Screenshot_452.png.webp?alt=media&token=1740e4d5-a32a-4a7c-8819-3a11a0145ac6"/></td></tr>
<tr><td> <em>Caption:</em> <p>The checkAnswers function hasnt changed much but quickly go over it. Checks if<br>the player has answered first or not if they have they cant answer<br>again til the next question. But if they haven&#39;t answered they send their<br>answer the game checks if it matches the correct answer and then if<br>it does match awards them points by the order on which they answered<br>in. At the end of this code it also shows the game calling<br>for the next round if all players have answered the question regardless if<br>it is right or wrong.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Frr268%2F2023-11-29T23.54.19Screenshot_453.png.webp?alt=media&token=94ca7dd6-6f5a-44f9-ac0f-52edf0cca8f0"/></td></tr>
<tr><td> <em>Caption:</em> <p>The trivia question has remanded the same besides some small changes in which<br>after the file reader has gotten the area in which the random question<br>is in line 1 is sent as the category, line 2 is sent<br>as the question. line 3 as the options, and line 4 is just<br>stored as the correct answer. But lines 1-3 are sent as payloads to<br>each client that will display the category, question, and options for the player.<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain the code flow for each of the steps of the game flow mentioned previously</td></tr>
<tr><td> <em>Response:</em> <p>explained the code and how it flows in the captions of the screenshots<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 4: </em> Misc </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707795-a9c94a71-7871-4572-bfae-ad636f8f8474.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Pull request from milestone3 to main</td></tr>
<tr><td>Not provided</td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-003-F23/it114-trivia-milestone3/grade/rr268" target="_blank">Grading</a></td></tr></table>
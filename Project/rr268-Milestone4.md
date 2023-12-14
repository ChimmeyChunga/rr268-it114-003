<table><tr><td> <em>Assignment: </em> IT114 Trivia Milestone4</td></tr>
<tr><td> <em>Student: </em> Romer Rodriguez (rr268)</td></tr>
<tr><td> <em>Generated: </em> 12/13/2023 11:08:17 PM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-003-F23/it114-trivia-milestone4/grade/rr268" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <p>Implement the features from Milestone4 from the proposal document:&nbsp;<a href="https://docs.google.com/document/d/1h2aEWUoZ-etpz1CRl-StaWbZTjkd9BDMq0b6TXK4utI/view">https://docs.google.com/document/d/1h2aEWUoZ-etpz1CRl-StaWbZTjkd9BDMq0b6TXK4utI/view</a></p>
</td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Categories can be configured before game begins </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707834-bf5a5b13-ec36-4597-9741-aa830c195be2.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshot(s) of the UI showing category selection</td></tr>
<tr><td><table><tr><td>Missing Image</td></tr>
<tr><td> <em>Caption:</em> (missing)</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain how the category selection is handled on the server-side</td></tr>
<tr><td> <em>Response:</em> <p>I was unsure how to implement this into my game without changing how<br>my questions are stored. I thought of listing all the current categories out<br>that are stored in the system and checking with categories should be in<br>or not, but couldn&#39;t figure out which client should be choosing the categories<br>for the game or not. Overall this was the hardest part to implement<br>and I couldn&#39;t get a successful implementation of it.<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Client will be able to upload new category/questions/answer (outside of an active game) </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshot(s) of the UI for adding related data</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Frr268%2F2023-12-14T03.11.25Screenshot_460.png.webp?alt=media&token=961642b0-c1e9-4350-8467-30f95c57cfaf"/></td></tr>
<tr><td> <em>Caption:</em> <p>Left side of the screenshot under the ready check has all the input<br>boxes for you to input you question.<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add screenshot(s) of the custom data available in the game</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Frr268%2F2023-12-14T03.15.14Screenshot_461.png.webp?alt=media&token=baea7ec2-3a70-4960-9dd6-246861014e89"/></td></tr>
<tr><td> <em>Caption:</em> <p>First created a form alongside with the ready check because it made sense<br>that while waiting for people to join people could create a custom question<br>of two if they wanted to for the game. So there is 4<br>fields one for the category, question, options, and correct answer. Once the submit<br>question button is clicked or they press enter all fields are submitted and<br>a BufferedWriter object is created to create new lines within where all my<br>questions are stored. Because of how my game is written the each field<br>must have its own line and be formatted properly so it is written<br>like new line insert the specific field, new line and insert next field.<br>This is so it causes no issues when the game tries to read<br>a new question. After it is submitted the program clears all fields of<br>text so it is easier to input a new question.<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Add screenshot(s) of how the custom data is saved on the server</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Frr268%2F2023-12-14T03.21.51Screenshot_462.png.webp?alt=media&token=e694c6d8-c2df-43ed-8b6c-57864e55a300"/></td></tr>
<tr><td> <em>Caption:</em> <p>This is the plaintext file where all my questions are stored, as you<br>can see it is formatted in a specific way so the game can<br>read the question properly. When the game adds a new question it starts<br>all the way at the end of the file and appends to it<br>in the format you can see in the screenshot.<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 4: </em> Briefly explain the related code logic for each part of this feature</td></tr>
<tr><td> <em>Response:</em> <p>Code was explained in the captions of one of the screenshots.<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Client can mark themselves “away” to be skipped in the turn flow but still be in the game </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshot(s) of the visual representation of someone "away"</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Frr268%2F2023-12-14T03.36.35Screenshot_463.png.webp?alt=media&token=23e68856-3d11-47d4-9175-3e1720f71dad"/></td></tr>
<tr><td> <em>Caption:</em> <p>Shows dave stepping away and coming back into the game.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Frr268%2F2023-12-14T03.50.32Screenshot_464.png.webp?alt=media&token=e93e72aa-d4ff-44a5-8327-67d5cac31778"/></td></tr>
<tr><td> <em>Caption:</em> <p>Shows dave trying to answer while stile having away status which he needs<br>to click here button in order to submit an answer.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Frr268%2F2023-12-14T03.52.52Screenshot_465.png.webp?alt=media&token=3a9e86c6-d529-468b-8507-3dafca043f40"/></td></tr>
<tr><td> <em>Caption:</em> <p>Code of how the buttons work.<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain the code logic</td></tr>
<tr><td> <em>Response:</em> <p>So when the player clicks on the away button it has an event<br>listener to when it is clicked it sends a payload of the AWAY<br>status to the serverthread where it is told in the game room to<br>change the player&#39;s isAway status to false. Once the player is in away<br>status in the code I have it that it also makes the player<br>unready so they can&#39;t answer any questions and the game can continue on<br>without other players waiting because in order to answer or be considered part<br>of the game you need to be ready and not away to answer.<br>Once the here button is clicked similar to the away button it sends<br>a payload of the AWAY status and should change it to false and<br>the player is able to participate again the game. I couldn&#39;t figure out<br>how to implement a way for the UI to show a player is<br>away so it is just in text as of now.<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 4: </em> Client can join as a spectator </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshot(s) of what a spectator can see</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Frr268%2F2023-12-14T04.02.08Screenshot_466.png.webp?alt=media&token=a75646b8-5a42-4738-a278-0d6d5a4c4e04"/></td></tr>
<tr><td> <em>Caption:</em> <p>Three clients up the two on the top are currently playing the game<br>while the third is spectating. As you can see the player participating can<br>see the game with the questions and answers. While the one spectating can<br>just chat and say hi to them but can&#39;t help them out unless<br>one is sharing their client screen somehow.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Frr268%2F2023-12-14T04.06.06Screenshot_468.png.webp?alt=media&token=c39837ea-bba1-4545-a75a-4806316e9a92"/></td></tr>
<tr><td> <em>Caption:</em> <p>Spectated players are ignored from turns because they are in the room but<br>currently not in a ready state because they missed the ready check. So<br>the game can progress even with them in the room because the next<br>turn only occurs once all READY players have answered not all players or<br>when time runs out of course.<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain how the code handles spectators</td></tr>
<tr><td> <em>Response:</em> <p>Code explained above in the caption showing code snippet.<br></p><br></td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-003-F23/it114-trivia-milestone4/grade/rr268" target="_blank">Grading</a></td></tr></table>
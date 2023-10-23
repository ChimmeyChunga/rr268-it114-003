<table><tr><td> <em>Assignment: </em> It114 Milestone1</td></tr>
<tr><td> <em>Student: </em> Romer Rodriguez (rr268)</td></tr>
<tr><td> <em>Generated: </em> 10/23/2023 4:41:55 PM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-003-F23/it114-milestone1/grade/rr268" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <ol><li>Create a new branch called Milestone1</li><li>At the root of your repository create a folder called Project if one doesn't exist yet</li><ol><li>You will be updating this folder with new code as you do milestones</li><li>You won't be creating separate folders for milestones; milestones are just branches</li></ol><li>Create a milestone1.md file inside the Project folder</li><li>Git add/commit/push it to Github (yes it'll be blank for now)</li><li>Create a pull request from Milestone1 to main (don't complete/merge it yet, just have it in open status)</li><li>Copy in the latest Socket sample code from the most recent Socket Part example of the lessons</li><ol><li>Recommended Part 5 (clients should be having names at this point and not ids)</li><li><a href="https://github.com/MattToegel/IT114/tree/Module5/Module5">https://github.com/MattToegel/IT114/tree/Module5/Module5</a>&nbsp;<br></li></ol><li>Fix the package references at the top of each file (these are the only edits you should do at this point)</li><li>Git add/commit the baseline</li><li>Ensure the sample is working and fill in the below deliverables</li><ol><li>Note: The client commands likely are different in part 5 with the /name and /connect options instead of just connect</li></ol><li>Get the markdown content or the file and paste it into the milestone1.md file or replace the file with the downloaded version</li><li>Git add/commit/push all changes</li><li>Complete the pull request merge from step 5</li><li>Locally checkout main</li><li>git pull origin main</li></ol></td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Startup </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshot showing your server being started and running</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Frr268%2F2023-10-23T20.01.48Screenshot_388.png.webp?alt=media&token=d305e62d-6607-4a3f-965c-7d6e8f59a4e3"/></td></tr>
<tr><td> <em>Caption:</em> <p>Server listening for port <br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add screenshot showing your client being started and running</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Frr268%2F2023-10-23T20.02.36Screenshot_389.png.webp?alt=media&token=f6d2363f-488e-4457-9f5d-76c4d8e62141"/></td></tr>
<tr><td> <em>Caption:</em> <p>client waiting for input<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Frr268%2F2023-10-23T20.05.23Screenshot_390.png.webp?alt=media&token=6a6e199c-5d8c-477c-937a-29307189cb6b"/></td></tr>
<tr><td> <em>Caption:</em> <p>server and client showing succesful connection<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain the connection process</td></tr>
<tr><td> <em>Response:</em> <p>For the Client it connects to the server by entering the command &quot;/connect&quot;<br>and whatever the localhost port number is which is set to &quot;localhost:3000&quot; for<br>our server. The client then connects to the server in which the server<br>creates a serverthread to process all of the information for that unique client.<br>For the messages that the server receives it first goes from the client<br>to the serverthread then the server room and relayed back to the serverthread<br>and back to the client.<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Sending/Receiving </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshot(s) showing evidence related to the checklist</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Frr268%2F2023-10-23T20.22.40Screenshot_392.png.webp?alt=media&token=ed6db799-a771-497d-8372-931852da3002"/></td></tr>
<tr><td> <em>Caption:</em> <p>two clients connected both being in the same room with IDS and talking<br>to each other<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Frr268%2F2023-10-23T20.24.57Screenshot_393.png.webp?alt=media&token=e553a626-d5b1-42b4-9148-bf34aa864e06"/></td></tr>
<tr><td> <em>Caption:</em> <p>Here show clients in seperate rooms talking but not seeing each others messages<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain how the messages are sent, broadcasted (sent to all connected clients), and received</td></tr>
<tr><td> <em>Response:</em> <p>From the client perspective, the client sends a message that the Serverthread receives<br>then the Room receives it from there the Room broadcasts the messages through<br>the serverthread and back to all the clients inside the room.<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Disconnecting / Terminating </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshot(s) showing evidence related to the checklist</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Frr268%2F2023-10-23T20.30.00Screenshot_394.png.webp?alt=media&token=0304f744-7c88-4308-9f67-c285abe341f8"/></td></tr>
<tr><td> <em>Caption:</em> <p>Shows the client disconnect from the server and the server acknowledging the disconnect<br>and cleaning up<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Frr268%2F2023-10-23T20.32.03Screenshot_395.png.webp?alt=media&token=6abeb527-98e8-4784-a959-042fdd28da62"/></td></tr>
<tr><td> <em>Caption:</em> <p>Shows proof of another user being disconnected from the server<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Frr268%2F2023-10-23T20.33.13Screenshot_396.png.webp?alt=media&token=3dd4f491-57dd-419f-9cb4-300459db6bdb"/></td></tr>
<tr><td> <em>Caption:</em> <p>Shows the user being disconnected from the server after the server closes<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain how the various disconnects/terminations are handled</td></tr>
<tr><td> <em>Response:</em> <p>When the command &quot;/disconnect&quot; is used by the client it terminates the socket<br>connection between the client and the server, the client program doesn&#39;t crash when<br>ever it disconnects because it only severs the connection without terminaing the client<br>program. The server doesn&#39;t crash whenever a client disconnects because it cleanups after<br>itself by discarding the serverthread in which the client was using before.<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 4: </em> Misc </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add the pull request for this branch</td></tr>
<tr><td> <a rel="noreferrer noopener" target="_blank" href="https://github.com/ChimmeyChunga/rr268-it114-003/pull/9">https://github.com/ChimmeyChunga/rr268-it114-003/pull/9</a> </td></tr>
<tr><td> <em>Sub-Task 2: </em> Talk about any issues or learnings during this assignment</td></tr>
<tr><td> <em>Response:</em> <p>No issues running client or server but it was really interesting to see<br>how they were built and understand how it works. I may not completely<br>get it but I think I have a general understanding and I am<br>excited to continue to understand it better and start to add my own<br>unique parts to it with my game as the semester continues.<br></p><br></td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-003-F23/it114-milestone1/grade/rr268" target="_blank">Grading</a></td></tr></table>
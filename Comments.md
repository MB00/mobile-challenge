## Questions

We understand that this is a coding test and time may be limited. To help us understand 
your work and any compromises you may have made. Please answer inline the questions below
and include in your final submission.

[What would you consider the most challenging task?]
Setting up the overall architecture of the app.  It was very time-consuming, 
and involved refreshing my memory on quite a few concepts.

[What did you not have time to add?]
1) Testing
2) Proper error handling
3) Proper splash screen with initial data loading
4) Data persistence

[What took the up majority of your time?]
Constructing the app architecture.  Once I had a solid foundation there, I could build off of it
relatively quickly.
  
[What would you do differently given more time?]
I would use more Jetpack components.  Specifically, I would use Jetpack Navigation to streamline
app flow (and to avoid using Activities for every screen), and try using Jetpack Compose to build
the UI, rather than XML.
  
[Are you happy with your solution, how could the application be improved?]
I think I'm reasonably happy with what I managed in the time provided, but there are A LOT of things
which could be added or improved.  First of all, I constructed all three app screens using
Activities, but the architecture might be better served using Fragments with Jetpack Navigation.
Especially for the `Change Category` screen, using an Activity was not ideal, but it allowed me to
complete the assignment faster, so I went with it.  Also, I didn't have time to implement a proper
splash screen Activity with initial data loading, but that would have been overkill for this
assignment anyway.

It turns out that the API returns `null` for every transaction category, so I ended up
just defaulting every transaction category to `Miscellaneous` for the purpose of completing
this assignment.  The user can successfully change this category, and will see this change
after being taken back to the `Transaction Detail` screen, but because there is no data persistence,
this change disappears into the ether as soon as the user leaves this screen and the Activity
is destroyed.  Ideally, persistence would be implemented and this would no longer be an issue.

[Did you learn anything new while completing this assignment?]
I learned that I have to use a Manifest attribute to allow cleartext traffic (HTTP).
Never had to use that before.

Otherwise, I stuck to concepts I already knew in order to complete the challenge on time, 
but I did end up refreshing my memory on a lot of concepts I haven't utilized in a long while, 
from setting up Dagger object graphs to making Rx calls work properly.
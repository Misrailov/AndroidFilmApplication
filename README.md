# AndroidFilmApplication
My application `AndroidFilmApplication` is a simple application I made to showcase my knowledge of Kotlin and Android Compose. Most of the struggle points were not utilising the language itself as I followed most of the lessons and utilised this language during the DevOps project. What made this application difficult through some points was the limitations of the API that I used.
A couple of limitations are:
- Many of the requests that were available didn't work or stopped working during the process of building the application.
- Doing detail requests didn't provide extra information, which is why I didn't make a detail page.
- I couldn't always rely on the API to be running, which made developer some things difficult.
- I split the titles as Series And Films in my application. My reason for this was that the API provided extra information like Number of Episodes, Episode Titles. However these usually didn't work, so now the application has a seperate class for two objects that are practically the same.

Where I did experience difficulties was with testing some aspects of my application, for example the viewmodels. I couldn't make tests for the FilmViewModel and the SerieViewModel as they utilised a pager. This doesnt "Idle" like the other viewmodels would do after completing their requests. Thus, I couldn't do the tests the same way I did for the other ViewModels. I could have done more research and maybe found a way, but the ViewModel tests were very difficult to get right during the DevOps project, which I imagine to be even harder using a Pager.
Thus I accepted my tests as they are and skipped the ViewModels which utilised the Pager.

## Extra Information:
 DocumentationMarkdown is easily accessible through the browser, however, it is less readable than the HTML documentation (DocumentationHtml) which is accessible by downloading the repo and opening it through the file explorer

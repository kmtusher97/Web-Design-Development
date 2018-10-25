var childWindow;

function createChildWindow() {
    var toolBar;
    var menuBar;
    var scrollBar;

    if( document.getElementById( "toolBarCheckBox" ).checked )
        toolBar = "yes";
    else
        toolBar = "no";

    if( document.getElementById( "menuBarCheckBox" ).checked )
        menuBar = "yes";
    else
        menuBar = "no";

    if( document.getElementById( "scrollBarCheckBox" ).checked )
        scrollBar = "yes";
    else
        scrollBar = "no";

    childWindow = window.open( "", "", ",tool bar = " + toolBar + ", menubar = " + menuBar + ", scrollBar = " + scrollBar );

    if( childWindow.closed )
        alert( "You attempted to interact with a closed window" );
    else
        childWindow.document.write( "This is a New Child Window" );

    document.getElementById( "closeButton" ).disabled = false;
    document.getElementById( "modifyButton" ).disabled = false;
    document.getElementById( "setURLButton" ).disabled = false;
}

function modifyChildWindow()
{
    if( childWindow.closed )
        alert( "You attempted to interact with a closed window" );
    else
        childWindow.document.write( "This is a Modified Child Window" );
}

function closeChildWindow()
{
    if( childWindow.closed )
        alert( "You attempted to interact with a closed window" );
    else
        childWindow.close();

    document.getElementById( "closeButton" ).disabled = true;
    document.getElementById( "modifyButton" ).disabled = true;
    document.getElementById( "setURLButton" ).disabled = true;
}

function setChildWindowURL()
{
    if( childWindow.closed )
        alert( "You attempted to interact with a closed window" );
    else
        childWindow.location = document.getElementById( "myChildURL" ).value;
}

/**
 * =====================================================================
 * Programming Project for NCEA Level 3, Standard 91906
 * ---------------------------------------------------------------------
 * Project Name:   PROJECT NAME HERE
 * Project Author: Tyler Eggers
 * GitHub Repo:    https://github.com/waimea-tjeggers/Level---3---Programming---Assessment
 * ---------------------------------------------------------------------
 * Notes:
 * Maze
 * =====================================================================
 */



import com.formdev.flatlaf.FlatDarkLaf
import java.awt.*
import java.awt.event.*
import javax.swing.*


/**
 * Launch the application
 */
fun main() {
    FlatDarkLaf.setup()     // Flat, dark look-and-feel
    val app = App()         // Create the app model
    MainWindow(app)         // Create and show the UI, using the app model
}


class Room(val name: String, val description: String, val north: Int, val east: Int, val south: Int, val west: Int )

/**
 * The application class (model)
 * This is the place where any application data should be
 * stored, plus any application logic functions
 */
class App() {
    // declaring blocked values
    val BLOCKED = -1

    // made room list
    var rooms = mutableListOf<Room>()
    var currentRoom = 0

    init {
        setupMap()
    }
    //Making Room List
    fun setupMap() {
        val entrance = Room("Entrance", "blah blah", 1, 5, BLOCKED, 3)
        val grandhall = Room( "Grandhall", "blah blah", 2, 9, 0 , 7)
        val throneroom = Room( "Throneroom", "blah blah", BLOCKED,BLOCKED, 1, BLOCKED )
        val barracks = Room( "Barracks", "blah barracks", BLOCKED, 0, BLOCKED, 4)
        val southWestTower = Room("South West Tower", "blah blah blah", 8, 3, BLOCKED, BLOCKED)
        val supplyRoom = Room("The Supply Room", "blah blah blah", 6, BLOCKED, 0, BLOCKED )
        val southEastTower = Room ("South East Tower", "blah blah blah", 10, BLOCKED, BLOCKED , 5)
        val lowerWesternHallway = Room("Lower Western Hallway", "blah blah blah", 12, 1, BLOCKED, 8)
        val queensGardens = Room ("The Queens Gardens", "blah blah blah", 13,7,4,BLOCKED)
        val lowerEasternHallway = Room ("Lower Eastern Hallway", "blah blah blah", 11, 10, BLOCKED ,1)
        val trainingGrounds = Room ("Training Grounds", "blah blah blah", 18, BLOCKED , 6, 9 )
        val kitchen = Room ("kitchen", "blah blah blah", 17, BLOCKED, 9, BLOCKED)
        val grandLibrary = Room ("Grand Library", "blah blah blah", 16, BLOCKED, 7, BLOCKED)
        val caretakersShed = Room ("The Caretakers Shed", "blah blah blah", 14, BLOCKED,8,BLOCKED)
        val servantsQuarters = Room ("The Servants Quarters", "blah blah blah", 15, BLOCKED, 13, BLOCKED)
        val northWestTower = Room ("North West Tower", "Blah blah blah", BLOCKED, 21,14,BLOCKED)
        val wizardsAlcove = Room ("The Wizards Alcove", "blah blah blah", BLOCKED, BLOCKED, 12, BLOCKED)
        val incinerator = Room ("The Incinerator", "blah blah blah", BLOCKED, 18 ,17 , BLOCKED)
        val grandForge = Room ("The Grand Forge", "blah blah blah", 19, BLOCKED, 10, 17)
        val northEastTower = Room ("North East Tower", "blah blah blah", BLOCKED, BLOCKED, 18, 20)
        val princessRoom = Room ("Princesses Bedroom", "blah blah blah", BLOCKED, 19,  BLOCKED, BLOCKED)
        val parentsBedroom = Room ("The King and Queens Bedroom", "Blah blah blah", 22, BLOCKED, BLOCKED, 15)
        val exit = Room ("The Exit Tunnel", "blah blah blah", BLOCKED, BLOCKED, 21,BLOCKED)

        //adding rooms
        rooms.add(entrance)
        rooms.add(grandhall)
        rooms.add(throneroom)
        rooms.add(barracks)
        rooms.add(southWestTower)
        rooms.add(supplyRoom)
        rooms.add(southEastTower)
        rooms.add(lowerWesternHallway)
        rooms.add(queensGardens)
        rooms.add(lowerEasternHallway)
        rooms.add(trainingGrounds)
        rooms.add(kitchen)
        rooms.add(grandLibrary)
        rooms.add(caretakersShed)
        rooms.add(servantsQuarters)
        rooms.add(northWestTower)
        rooms.add(wizardsAlcove)
        rooms.add(incinerator)
        rooms.add(grandForge)
        rooms.add(northEastTower)
        rooms.add(princessRoom)
        rooms.add(parentsBedroom)
        rooms.add(exit)

    }

    // Application logic functions
    fun moveSouth() {

    }
    fun moveNorth() {
    }
    fun moveWest() {
    }
    fun moveEast() {
    }
}


/**
 * Main UI window (view)
 * Defines the UI and responds to events
 * The app model should be passwd as an argument
 */
class MainWindow(val app: App) : JFrame(), ActionListener {

    // Fields to hold the UI elements
    private lateinit var northButton: JButton
    private lateinit var southButton: JButton
    private lateinit var eastButton: JButton
    private lateinit var westButton: JButton
    private lateinit var gameTitle : JLabel
    private lateinit var roomName : JLabel
    private lateinit var roomDescription : JLabel
    private lateinit var roomNameNorth : JLabel
    private lateinit var roomNameEast : JLabel
    private lateinit var roomNameSouth : JLabel
    private lateinit var roomNameWest : JLabel
    /**
     * Configure the UI and display it
     */
    init {
        configureWindow()               // Configure the window
        addControls()                   // Build the UI
        addLabels(app = app)

        setLocationRelativeTo(null)     // Centre the window
        isVisible = true                // Make it visible

        updateView()                    // Initialise the UI
    }

    /**
     * Configure the main window
     */
    private fun configureWindow() {
        title = "THE CASTLE OF LORD VOLKINHAR"
        contentPane.preferredSize = Dimension(1000, 400)
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        isResizable = false
        layout = null

        pack()
    }

    /**
     * Populate the UI with UI controls
     */
    private fun addControls() {
        val baseFont = Font(Font.SANS_SERIF, Font.PLAIN, 36,)

        northButton = JButton("↑")
        northButton.bounds = Rectangle(0, 10, 70, 40)
        northButton.font = baseFont
        northButton.background = Color(0,0,0,0)
        northButton.border = null
        add(northButton)

        eastButton = JButton("→")
        eastButton.bounds = Rectangle(0,50,70,40)
        eastButton.font = baseFont
        eastButton.background = Color(0,0,0,0)
        eastButton.border = null
        eastButton.addActionListener(this)
        add(eastButton)

        southButton = JButton("↓")
        southButton.bounds = Rectangle(0,90,70,40)
        southButton.font = baseFont
        southButton.background = Color(0,0,0,0)
        southButton.border = null
        southButton.addActionListener(this)
        add(southButton)

        westButton = JButton("←")
        westButton.bounds = Rectangle(0,130,70,40)
        westButton.font = baseFont
        westButton.background = Color(0,0,0,0)
        westButton.border = null
        westButton.addActionListener(this)
        add(westButton)
    }

    //populate ui with labels
    private fun addLabels(app: App) {
        gameTitle = JLabel("The Castle of Lord Volkinhar")
        gameTitle.bounds = Rectangle(265,0,390,50)
        gameTitle.font = Font(Font.SANS_SERIF, Font.PLAIN, 24)
        add(gameTitle)

        roomName = JLabel("NAME HERE")
        roomName.bounds = Rectangle(400,60, 115,30)
        roomName.font = Font(Font.SANS_SERIF, Font.PLAIN, 15)
        add(roomName)

        roomDescription = JLabel("Description HERE")
        roomDescription.bounds = Rectangle(300,120,295,125)
        roomDescription.font = Font(Font.SANS_SERIF, Font.PLAIN, 15)
        add(roomDescription)

        roomNameNorth = JLabel("ROOM NAME NORTH")
        roomNameNorth.bounds = Rectangle(70,10,195,40)
        roomNameNorth.font = Font(Font.SANS_SERIF, Font.PLAIN, 15)
        add(roomNameNorth)

        roomNameEast = JLabel("ROOM NAME EAST")
        roomNameEast.bounds = Rectangle(70,50,195,40)
        roomNameEast.font = Font(Font.SANS_SERIF, Font.PLAIN, 15)
        add(roomNameEast)

        roomNameSouth = JLabel("ROOM NAME SOUTH")
        roomNameSouth.bounds = Rectangle(70,90,195,40)
        roomNameSouth.font = Font(Font.SANS_SERIF, Font.PLAIN, 15)
        add(roomNameSouth)

        roomNameWest = JLabel("ROOM NAME WEST")
        roomNameWest.bounds = Rectangle(70,130,195,40)
        roomNameWest.font = Font(Font.SANS_SERIF, Font.PLAIN, 15)
        add(roomNameWest)




    }


    /**
     * Update the UI controls based on the current state
     * of the application model
     */
    fun updateView() {
        val room = app.rooms[app.currentRoom]

        roomName.text = room.name
        roomDescription.text = room.description
        roomNameNorth.text = if(room.north == app.BLOCKED) "BLOCKED" else app.rooms[room.north].name
        roomNameEast.text = if(room.north == app.BLOCKED) "BLOCKED" else app.rooms[room.east].name
        roomNameSouth.text = if(room.south == app.BLOCKED) "BLOCKED" else app.rooms[room.south].name
        roomNameWest.text = if(room.north == app.BLOCKED) "BLOCKED" else app.rooms[room.west].name


    }

    /**
     * Handle any UI events (e.g. button clicks)
     * Usually this involves updating the application model
     * then refreshing the UI view
     */
    override fun actionPerformed(e: ActionEvent?) {
        when (e?.source) {

        }
    }

}


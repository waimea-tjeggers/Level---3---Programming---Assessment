/**
 * =====================================================================
 * Programming Project for NCEA Level 3, Standard 91906
 * ---------------------------------------------------------------------
 * Project Name:   PROJECT NAME HERE
 * Project Author: Tyler Eggers
 * GitHub Repo:    https://github.com/waimea-tjeggers/Level---3---Programming---Assessment
 * ---------------------------------------------------------------------
 * Notes:
 * Find 3 key items
 * multiple rooms across the castle
 * solve riddles
 * interact with items in certain rooms
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
    // Constants defining any key values
    val BLOCKED = -1

    // Data fields
    var rooms = mutableListOf<Room>()
    var currentRoom = 0

    init {
        setupMap()
    }

    fun setupMap() {
        val entrance = Room("Entrance", "blah blah", 1, 5, BLOCKED, 3)
        val grandhall = Room( "Grandhall", "blah blah", 2, 9, 0 , 7)
        val throneroom = Room( "Throneroom", "blah blah", 22,BLOCKED, 1, BLOCKED )
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
        val parentsBedroom = Room ("The King and Queens Bedroom", "Blah blah blah", BLOCKED, BLOCKED, BLOCKED, 15)
        val secretRoom = Room ("The Hidden Room", "blah blah blah", 23, BLOCKED,2,BLOCKED)
        val exit = Room ("The Exit Tunnel", "blah blah blah", BLOCKED, BLOCKED, 22,BLOCKED)


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
        rooms.add(secretRoom)
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
    private lateinit var roomName : JLabel
    private lateinit var roomDescription : JTextField

    /**
     * Configure the UI and display it
     */
    init {
        configureWindow()               // Configure the window
        addControls()                   // Build the UI

        setLocationRelativeTo(null)     // Centre the window
        isVisible = true                // Make it visible

        updateView()                    // Initialise the UI
    }

    /**
     * Configure the main window
     */
    private fun configureWindow() {
        title = "THE CASTLE OF LORD VOLKINHAR"
        contentPane.preferredSize = Dimension(1000, 500)
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        isResizable = false
        layout = null

        pack()
    }

    /**
     * Populate the UI with UI controls
     */
    private fun addControls() {
        val baseFont = Font(Font.SANS_SERIF, Font.PLAIN, 36)

        northButton = JButton("↑")
        northButton.horizontalAlignment = SwingConstants.CENTER
        northButton.bounds = Rectangle(0, 10, 70, 70)
        northButton.font = baseFont
        add(northButton)

        southButton = JButton("↓")
        southButton.bounds = Rectangle(0,50,70,70)
        southButton.font = baseFont
        southButton.addActionListener(this)     // Handle any clicks
        add(southButton)

        eastButton = JButton("↓")
        eastButton.bounds = Rectangle(0,90,70,70)
        eastButton.font = baseFont
        eastButton.addActionListener(this)     // Handle any clicks
        add(eastButton)

        westButton = JButton("↓")
        westButton.bounds = Rectangle(0,130,70,70)
        westButton.font = baseFont
        westButton.addActionListener(this)     // Handle any clicks
        add(westButton)
    }


    /**
     * Update the UI controls based on the current state
     * of the application model
     */
    fun updateView() {
        //nameLabel.text = app.rooms[app.currentRoom].name
    }

    /**
     * Handle any UI events (e.g. button clicks)
     * Usually this involves updating the application model
     * then refreshing the UI view
     */
    override fun actionPerformed(e: ActionEvent?) {
        when (e?.source) {
            southButton -> {
                app.moveSouth()
                updateView()
            }
        }
    }

}


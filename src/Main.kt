/**
 * =====================================================================
 * Programming Project for NCEA Level 3, Standard 91906
 * ---------------------------------------------------------------------
 * Project Name:   PROJECT NAME HERE
 * Project Author: Tyler Eggers
 * GitHub Repo:    https://github.com/waimea-tjeggers/Level---3---Programming---Assessment
 * ---------------------------------------------------------------------
 * Notes:
 * PROJECT NOTES HERE
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


/**
 * The application class (model)
 * This is the place where any application data should be
 * stored, plus any application logic functions
 */
class App() {
    // Constants defining any key values
    val MAX_CLICKS = 10

    // Data fields
    var clicks = 0

    // Application logic functions
    fun moveSouth() {
        clicks++
        if (clicks > MAX_CLICKS) clicks = MAX_CLICKS
    }
    fun moveNorth() {
        clicks++
        if (clicks > MAX_CLICKS) clicks = MAX_CLICKS
    }
    fun moveWest() {
        clicks++
        if (clicks > MAX_CLICKS) clicks = MAX_CLICKS
    }
    fun moveEast() {
        clicks++
        if (clicks > MAX_CLICKS) clicks = MAX_CLICKS
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
        if (app.clicks == app.MAX_CLICKS) {
            northButton.text = "Max clicks reached!"
            southButton.isEnabled = false
        }
        else {
            northButton.text = "You clicked ${app.clicks} times"
            southButton.isEnabled = true
        }
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


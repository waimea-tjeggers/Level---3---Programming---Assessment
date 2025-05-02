/**
 * =====================================================================
 * Programming Project for NCEA Level 3, Standard 91906
 * ---------------------------------------------------------------------
 * Project Name:   CASTLE VOLKINHAR
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
import java.awt.font.TextAttribute
import java.sql.Wrapper
import javax.swing.*


/**
 * Launch the application
 */
fun main() {
    FlatDarkLaf.setup()     // Flat, dark look-and-feel
    val app = App()         // Create the app model
    MainWindow(app)         // Create and show the UI, using the app model
}


class Room(
    val name: String,
    val description: String,
    val north: Int,
    val east: Int,
    val south: Int,
    val west: Int
)

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
        val entrance = Room("Entrance", "Travelling along the abandoned road you knew you shouldn't be here but something pulled you along, something unnatural. before you knew it your legs had taken you somewhere you never should have been. towering infront of you was a stone wall, covered in moss and vines. making a mistake you attempt to climb up the wall. when your almost at the top you hear a cracking as the top section of the wall crumbled inwards. everything about Caslte Volkinhar was wrong, you shouldn't be here. you must escape ", 1, 5, BLOCKED, 3)
        val grandhall = Room( "Grandhall", "you enter a giant room, large enough to fit an army, torches flickered despite the place being long abandoned. you'd heard the stories of the tyrant Volkinhar, the dark arts he practised, the people he associated with. whatever dark magic ha once cursed this place were still lingering. to either side of you is a hallway and infront of you was a gilded throne that seemed to give off a dark energy. nothing about this place was natural. the less time spent here the better", 2, 9, 0 , 7)
        val throneroom = Room( "Throneroom", "despite knowing better you approached the gilded throne. fear clutching at your heart. as you approach you see a skeleton slumped against it with a note.'we got here too late, it seems that the cursed king has an escape route hidden in his chambers.whatever beasts and demons he left behind to deal with us will pick us off long before we get there'. as you put the note back you feel a presence that sets off every instinct of fear in your body. it was watching, toying. you best leave", BLOCKED,BLOCKED, 1, BLOCKED )
        val barracks = Room( "Barracks", "as you walked west you came across an old crumbling building with an image of a blade across the door. it seemed this was the barracks where his soldiers slept. as you forced the door open what you saw horrified you. skeletons lay strewn about the place, most missing limbs or fine dust where they should be. the beds were either rotting or destroyed, bedsheets caked with dried blood. a massacre happened here. as you looked closer you saw claw marks along the walls, far too deep and destructive to be any kind of animal. you knew you didnt want to be here, your only exit is back the way you came or advance out the other end ", BLOCKED, 0, BLOCKED, 4)
        val southWestTower = Room("South West Tower", "towering above you was one of the four towers that corner this infernal castle. crumbling and over grown it seemed as if it would collapse at any second. vines wind around it like snakes climbing for the sun. more bodies of soldiers lay at its base, though they held weapons each were rusted with blood. it seemed that the blades they held had no effect whatever hunted them", 8, 3, BLOCKED, BLOCKED)
        val supplyRoom = Room("The Supply Room", "as you forced the door open you see a room filled with crates and cupboards, weapon racks and armour stands. it was a supply room. crates were knocked over, blades lay on the ground and rats had picked away whatever food remained. the lack of windows gave this place an imposing darkness. you swore you could hear something scuttle around but hoped it was just a rat. two doors sat at either end. return to where you came from or advance through", BLOCKED, 6, BLOCKED, 0 )
        val southEastTower = Room ("South East Tower", "towering above you was one of the four towers that corner this infernal castle. crumbling and over grown it seemed as if it would collapse at any second. vines wind around it like snakes climbing for the sun. rats scampered around clearly not use to human presence, but they didnt seem to be scared of you, they were scared of something else.", 10, BLOCKED, BLOCKED, 5)
        val lowerWesternHallway = Room("Lower Western Hallway", "a long hallway, ripped up carpet lined the floor while torches flickered along the walls. at you heard a noise behind you, coming from the grand hall, something falling. you hoped it it was just another critter running around. as you walked deeper in you felt that same presence you felt at the throne, looking in the doorway you saw shelfs upon shelfs of books, covered in dust and mold. further ahead you could see plants growing along the walls, a garden of some sorts", 12, 1, BLOCKED, 8)
        val queensGardens = Room ("The Queens Gardens", "whatever dignified garden this might have once been has fallen into chaos. where once might of been roses and well trimmed hedges now grew creaking trees whose branches seem to be trying to block out the very sky. roses black and wilted, only the thorns remain. left to their own devices the plants grew wildly. behind you stood the clearing below the tower, to your right loomed the imposing hallway and ahead was a greenhouse or a caretakers shed. plants grew through broken windows as if seeking vengence. ", 13,7,4,BLOCKED)
        val lowerEasternHallway = Room ("Lower Eastern Hallway", "a long hallway, ripped up carpet lined the floor while torches flickered along the walls.  at you heard a noise behind you, coming from the grand hall, something falling. you hoped it it was just another critter running around. as you wandered through you smelled something horrid, like rotting meat. looking in you saw old stoves and benches, a cooler long left open, allowing rotted meat to waft. at the end of the hallway leading out you could make out the shape of a training armour with a wooden shield and old helmet.", 11, 10, BLOCKED ,1)
        val trainingGrounds = Room ("Training Grounds", "as you walked out you saw old training dummies everywhere, most seemed to be ripped through by some kind of animal. deep gashes revealed straw guts, wooden weapons snapped and broken. as you inspect the stone wall you something seems to have slashed it. deep gashes ripped through it. each one long as you are tall. you could fit almost your entire finger inside ot was so deep.whatever did this was not of this world. you didnt believe the stories they told but it seemed more and more likely now.behind you stood the clearing for the tower. to your side was the hallway leading inside and infront of you stood some kind of forge", 18, BLOCKED , 6, 9 )
        val kitchen = Room ("kitchen", "the first thing you noticed when you walked in was the smell, strong and pungent it assaulted your senses, leaving you gagging. looking around you saw pans and skillets scattered around, some scratched and others dented as if used for weaponry. it didnt seem to the chefs any good judging by the corpses littered around. you looked around for the exit, desperately wanting to escape the scent. behind you was the door back to the hallway but ahead was another door you slighlty ajar but you couldn't quite make out what was inside", 17, BLOCKED, 9, BLOCKED)
        val grandLibrary = Room ("Grand Library", "as you stepped in it was like a maze, all books rotted or faded, each shelf on the verge of collapse. as you wandered deeper inside you felt the cursed aura growing stronger, the books almost seemed to be warped here. every ounce of your being wanted to flee back to the hallway but some small part of you wanted to push forwards and see whats ahead. you saw a sign that made your blood run cold 'the wizards alcove, do not enter without permission'", 16, BLOCKED, 7, BLOCKED)
        val caretakersShed = Room ("The Caretakers Shed", "the plants jad taken over the place with a vengeance, they grew out of every crack in the ground, through every shattered pane of glass.thorns wrapped around old gardening tools like they were trying to suffocate them, as if they were alive or guided by some dark magics. you froze as you heard a noise, only for a second but most definitely there. something else was here in the castle, something big. something about it made your blood run cold. either you could head back to the gardens or push forward and hope to escape", 14, BLOCKED,8,BLOCKED)
        val servantsQuarters = Room ("The Servants Quarters", "a room filled with bunks and drawers. looking inside you found the first piece of clothing in this place, not claimed but rot or rat. it was a servants uniform, folded cleanly and properly. as you walked further in it seemed as if something had pushed through here. bunks were toppled and drawers were crushed. at the end of the room was a door way, the door sat outside not too far away. something and ripped it off its hinges, tearing chunks out of the wall whilst it was at it", 15, BLOCKED, 13, BLOCKED)
        val northWestTower = Room ("North West Tower", "towering above you was one of the four towers that corner this infernal castle. crumbling and over grown it seemed as if it would collapse at any second. vines wind around it like snakes climbing for the sun. there was a massive chunks ripped out of the ground, as if a beast moving too fast had dug its claws into the ground in an attempt to slow down. behind you, possibly at the gardens, you heard an unearthly roar. no man nor beast could have made that sound. it had found your scent, you needed to leave. now. to your side you saw a door that had the sign the royals room on it", BLOCKED, 21,14,BLOCKED)
        val wizardsAlcove = Room ("The Wizards Alcove", "this is where it had all started and you knew it. everything about this place oozed darkness and despair, as if hell itself had seeped into its very walls. there was a skeleton slumped against the wall with a journal open in its hands. 'it was pointless, no matter what i did i couldn't please that crazed bastard. he pushed me to this.now with the armies braking into our walls as I write this I know I will not see the end of the day. but this infernal magic allows me to get the last laugh. with the kaldinsar released it shall massacre them, this demonic beast shall kill me aswell but i do not care, bound to this castle for all eternity i shall make sure my so called king never returns. you put the journal and turn around. too terrified to read anything else", BLOCKED, BLOCKED, 12, BLOCKED)
        val incinerator = Room ("The Incinerator", "a kiln stands, filled with bits of old wood and burned food, somehow not having decayed over all this time. it was an incinerator, one used to dispose of waste, and given his reputation most likely corpses aswell. as you got closer you noticed something strange. the bricks had retained the heat even after all this time. as you moved some of the ashes around you saw that some embers were even still burning. looking around you see a door that leads to some kind of kitchen, a foul scent tickling your nose. or a building of some kind filled with smithing equipment. ", BLOCKED, 18 ,11 , BLOCKED)
        val grandForge = Room ("The Grand Forge", "moving in you see a forge, massive and imposing. tongs and molds scattered all around the place, scrap metal piled against the walls. as you take a closer looks you see ash scattered around. the scrap metal was rusted red, not only from water nut also from blood. aprons lay discarded on the floors. a half made blade lay on an anvil. missing its handle with the blade warped and uneven. ahead of you lay an empty court yard. to your side was a door leading to a pit of ash and behind you was a empty clearing with a training dummy standing nearby.", 19, BLOCKED, 10, 17)
        val northEastTower = Room ("North East Tower", "towering above you was one of the four towers that corner this infernal castle. crumbling and over grown it seemed as if it would collapse at any second. vines wind around it like snakes climbing for the sun. this is the only place in this forsaken hellhole that seemed to be at peace, that doesnt set off every part of your brain. but you knew you couldn't stay here, not if you wanted to escape, back behind you was the forge but to your side you saw a room labelled princess", BLOCKED, BLOCKED, 18, 20)
        val princessRoom = Room ("Princesses Bedroom", "it seemed to be a bedroom of some sorts, or was. every item was upturned or destroyed. the window was shattered. the closet was tipped. the bed split down the middle and blood stained the walls. on the ground was a dairy. 'Mother and especially father are losing it. pushing that new wizard to perform his miracles. but its not just his miracles. i've heard what they want him to do. to connect with demons and hell itself. evem if hel is real they seem to think these so called demons they summon will bow to them. its absurd. I must leave as soon as possible, turn myself over to king of the west and perhaps he might spare me. when his men get here i'll just' you can't make out some of it as blood has covered the words 'or if need be i can take the secret tunnel in mum and dads room. the door behind my dresser leads to their room'. as you tried to open if you found it stuck. as you pushed against it you looked out the window again and saw something. a massive scaled tail slithering up to the roof of the castle out of sight. you need to leave. NOW", BLOCKED, 19,  BLOCKED, BLOCKED)
        val parentsBedroom = Room ("The King and Queens Bedroom", "you push in and slam the door behind. you manged to shove the dresser and closet infront of the door like it will even slow the thing down, whatever it is. taking a deep breath you start to upturn things trying to find an exit. another roar, closer, more demonic. you must find it", 22, BLOCKED, BLOCKED, 15)
        val exit = Room ("The Exit Tunnel", "as you spot the exit tunnel you hear some unholy sound behind you. something coming closer. as you looked back you saw a massive arm push through, as wide as the door to the bedroom and almost a meter long from what you could see. you scramble, getting up you sprint down the tunnel. getting out you sprint home without looking back. you swore never to return as next time you might not be lucky enough to escape castle volkinhar", BLOCKED, BLOCKED, BLOCKED,BLOCKED)

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
    private lateinit var roomDescription : JTextArea
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
        northButton.addActionListener(this)
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
        roomName.bounds = Rectangle(400,60, 250,30)
        roomName.font = Font(Font.SANS_SERIF, Font.PLAIN, 15)
        add(roomName)

        roomDescription = JTextArea("Description HERE")
        roomDescription.bounds = Rectangle(200,100,500,300)
        roomDescription.font = Font(Font.SANS_SERIF, Font.PLAIN, 15)
        roomDescription.lineWrap = true
        add(roomDescription)

        roomNameNorth = JLabel("ROOM NAME NORTH")
        roomNameNorth.bounds = Rectangle(70,10,250,40)
        roomNameNorth.font = Font(Font.SANS_SERIF, Font.PLAIN, 15)
        add(roomNameNorth)

        roomNameEast = JLabel("ROOM NAME EAST")
        roomNameEast.bounds = Rectangle(70,50,250,40)
        roomNameEast.font = Font(Font.SANS_SERIF, Font.PLAIN, 15)
        add(roomNameEast)

        roomNameSouth = JLabel("ROOM NAME SOUTH")
        roomNameSouth.bounds = Rectangle(70,90,250,40)
        roomNameSouth.font = Font(Font.SANS_SERIF, Font.PLAIN, 15)
        add(roomNameSouth)

        roomNameWest = JLabel("ROOM NAME WEST")
        roomNameWest.bounds = Rectangle(70,130,250,40)
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
        roomNameEast.text = if(room.east == app.BLOCKED) "BLOCKED" else app.rooms[room.east].name
        roomNameSouth.text = if(room.south == app.BLOCKED) "BLOCKED" else app.rooms[room.south].name
        roomNameWest.text = if(room.west == app.BLOCKED) "BLOCKED" else app.rooms[room.west].name

        northButton.isEnabled = room.north != app.BLOCKED
        eastButton.isEnabled = room.east != app.BLOCKED
        southButton.isEnabled = room.south != app.BLOCKED
        westButton.isEnabled = room.west != app.BLOCKED
    }

    /**
     * Handle any UI events (e.g. button clicks)
     * Usually this involves updating the application model
     * then refreshing the UI view
     */
    override fun actionPerformed(e: ActionEvent?) {
        val room = app.rooms[app.currentRoom]
        println(room.name)

        when (e?.source) {
            northButton -> app.currentRoom = room.north
            eastButton -> app.currentRoom = room.east
            southButton -> app.currentRoom = room.south
            westButton -> app.currentRoom = room.west
        }

        updateView()
    }

}


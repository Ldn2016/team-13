//
//  GameViewController.swift
//  Maze
//
//  Created by Jared Davidson on 2/3/16.
//  Copyright (c) 2016 Archetapp. All rights reserved.
//

import UIKit
import SpriteKit
import Foundation

class GameViewController: UIViewController {

    
    var timerCount = 0
    var timerRunning = false
    
    
    
    @IBOutlet weak var timerLabel: UILabel! //ADD Label
    @IBOutlet weak var textField: UITextField! //Add TextField /Enter any number to Countdown

    
    override func viewDidLoad() {
        super.viewDidLoad()

        
    
        
        if let scene = GameScene(fileNamed:"GameScene") {
            // Configure the view.
            let skView = self.view as! SKView
            skView.showsFPS = true
            skView.showsNodeCount = true
            
            /* Sprite Kit applies additional optimizations to improve rendering performance */
            skView.ignoresSiblingOrder = true
            
            /* Set the scale mode to scale to fit the window */
            scene.scaleMode = .aspectFill
            
            skView.presentScene(scene)
        }
    }

    override var shouldAutorotate : Bool {
        return true
    }

    override var supportedInterfaceOrientations : UIInterfaceOrientationMask {
        if UIDevice.current.userInterfaceIdiom == .phone {
            return .allButUpsideDown
        } else {
            return .all
        }
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Release any cached data, images, etc that aren't in use.
    }

    override var prefersStatusBarHidden : Bool {
        return true
    }
}

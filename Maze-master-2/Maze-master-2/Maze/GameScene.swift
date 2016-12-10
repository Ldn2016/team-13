//
//  GameScene.swift
//  Maze
//
//  Created by Jared Davidson on 2/3/16.
//  Copyright (c) 2016 Archetapp. All rights reserved.
//

import SpriteKit
import CoreMotion

class GameScene: SKScene, SKPhysicsContactDelegate{
    
    let manager = CMMotionManager()
    var player = SKSpriteNode()
    var endNode = SKSpriteNode()
    
    override func didMove(to view: SKView) {
        
        
        self.physicsWorld.contactDelegate = self
        
        player = self.childNode(withName: "player") as! SKSpriteNode
        
        manager.startAccelerometerUpdates()
        manager.accelerometerUpdateInterval = 0.1
        manager.startAccelerometerUpdates(to: OperationQueue.main){
            (data, error) in
            
            self.physicsWorld.gravity = CGVector(dx: CGFloat((data?.acceleration.x)!) * -5, dy: CGFloat((data?.acceleration.y)!) * -5)
            
        }
       
    }
    
    
    override func update(_ currentTime: TimeInterval) {
        /* Called before each frame is rendered */
    }
}

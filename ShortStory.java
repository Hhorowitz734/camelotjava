import com.actions.*;
import com.entities.Character;
import com.entities.Item.Items;
import com.entities.*;
import com.entities.Place.Places;
import com.playerInput.*;
import com.storygraph.*;
import com.sequences.*;


public class ShortStory implements IStory {

    private ActionMap map;
    private INode root;

    //Characters
    private Character mc;
    private Character opponent;
    private Character shopkeeper;

    //Items
    private Item coin;
    private Item woodPile;
    private Item torch;
    private Item evilBook;
    private Item poison;
    private Item healingPotion;
    private Item sword;
    private Item lovePotion;
    private Item chickenLeg;

    //Places
    private Place ruins;
    private Place alchemyShop;
    private Place storage;
    private Place dungeon;

    //NodeLabels
    private enum NodeLabels{ 
        Start, 
        Init, 
        Storage,
        StorageChest,
        Coins,
        AlchemyShopDoor,
        AlchemyShopCauldron,
        ChickenLeg,
        GainPower,
        LosePower,
        LosePowerChickenLeg,
        GainPowerChickenLeg,
        DungeonDoor,
        DungeonDoor2,
        AlchemyShopBar,
        LovePotion,
        HealingPotion,
        AddLovePotion,
        AddHealingPotion,
        StartBattle,
        StartBattle2,
        Torch,
        Sword,
        Poison,
        Woodpile,
        EvilBook,
        AddTorch,
        AddSword,
        AddPoison,
        BattleTorch,
        BattleSword,
        BattlePoison,
        Die,
        Win,
    }
    
    private enum ChoiceLabels {
        LookAt,
        CollectSword,
        PickUpWoodpile,
        CreateTorch,
        AddToList,
        ExitTorch,
        ExitSword,
        CreatePoison,
        Drink,
        ExitPoison,
        PickUpPoison,
        PickUpSword,
        PickUpTorch,
        PickUpCoins,
        TorchSelfAttack,
        TorchAttack,
        PutDownSword,
        SwordAttack,
        DrinkPoison,
        PoisonAttack,
        DrinkHealingPotion,
        DrinkLovePotion,
        AttackOpponentLovePotion,
        OpenDungeonDoor2,
        ExitAlchemyShop1,
        ExitAlchemyShop2,
        ExitAlchemyShop3,
        PutDownChickenLeg,
        DrinkChickenLeg,
        WalkToCauldron,
        OpenAlchemyShopBar,
        ExitStorage,
        AddToListHealingPotion,
        AddToListLovePotion,
        GiveCoinsLovePotion,
        GiveCoinsHealingPotion,
        CreateItemChickenLeg,
        OpenFurniture,
        OpenDungeonDoor
    }
    

    
    @Override
    public ActionMap getMap() { 
        map = new ActionMap();
    
        map.add(NodeLabels.Start.toString(), getStartNodeSequence());
        map.add(NodeLabels.Init.toString(), getinitNodeSequence());
        map.add(NodeLabels.Storage.toString(), getStorageNodeSequence());
        map.add(NodeLabels.StorageChest.toString(), getStorageChestNodeSequence());
        map.add(NodeLabels.Coins.toString(), getCoinsNodeSequence());
        map.add(NodeLabels.AlchemyShopDoor.toString(), getAlchemyShopDoorNodeSequence());
        map.add(NodeLabels.AlchemyShopCauldron.toString(), getAlchemyShopCauldronNodeSequence());
        map.add(NodeLabels.ChickenLeg.toString(), getChickenLegNodeSequence());
        map.add(NodeLabels.GainPower.toString(), getGainPowerNodeSequence());
        map.add(NodeLabels.LosePower.toString(), getLosePowerNodeSequence());
        map.add(NodeLabels.GainPowerChickenLeg.toString(), getGainPowerChickenLegNodeSequence());
        map.add(NodeLabels.LosePowerChickenLeg.toString(), getLosePowerChickenLegNodeSequence());
        map.add(NodeLabels.DungeonDoor.toString(), getDungeonDoorNodeSequence());
        map.add(NodeLabels.AddSword.toString(), getAddSwordNodeSequence());
        map.add(NodeLabels.DungeonDoor2.toString(), getDungeonDoor2NodeSequence());
        map.add(NodeLabels.AlchemyShopBar.toString(), getAlchemyShopBarNodeSequence());
        map.add(NodeLabels.LovePotion.toString(), getLovePotionNodeSequence());
        map.add(NodeLabels.HealingPotion.toString(), getHealingPotionNodeSequence());
        map.add(NodeLabels.AddLovePotion.toString(), getAddLovePotionNodeSequence());
        map.add(NodeLabels.AddHealingPotion.toString(), getAddHealingPotionNodeSequence());
        map.add(NodeLabels.StartBattle.toString(), getStartBattleNodeSequence());
        map.add(NodeLabels.StartBattle2.toString(), getStartBattle2NodeSequence());
        map.add(NodeLabels.Torch.toString(), getTorchNodeSequence());
        map.add(NodeLabels.Sword.toString(), getSwordNodeSequence());
        map.add(NodeLabels.Poison.toString(), getPoisonNodeSequence());
        map.add(NodeLabels.Woodpile.toString(), getWoodpileNodeSequence());
        map.add(NodeLabels.EvilBook.toString(), getEvilBookNodeSequence());
        map.add(NodeLabels.AddTorch.toString(), getAddTorchNodeSequence());
        map.add(NodeLabels.AddPoison.toString(), getAddPoisonNodeSequence());
        map.add(NodeLabels.BattleTorch.toString(), getBattleTorchSequence());
        map.add(NodeLabels.BattleSword.toString(), getBattleSwordSequence());
        map.add(NodeLabels.BattlePoison.toString(), getBattlePoisonSequence());
        map.add(NodeLabels.Die.toString(), getDieNodeSequence());
        map.add(NodeLabels.Win.toString(), getWinNodeSequence());
    
        return map;
    }
    

    @Override
    public INode getRoot() { //return new Node("root"); }
      
        var losePowerStartBattleNode=new Node(NodeLabels.LosePower.toString());
        var gainPowerStartBattleNode=new Node(NodeLabels.GainPower.toString());
        losePowerStartBattleNode.addChild(new ActionChoice(ChoiceLabels.DrinkHealingPotion.toString(),
                healingPotion,
                ActionChoice.Icons.drink,
                "Drink HealingPotion to gain power",
                false),
                gainPowerStartBattleNode);
      
        var startBattle2Node=new Node(NodeLabels.StartBattle2.toString());
        startBattle2Node.addChild(new ActionChoice(ChoiceLabels.DrinkLovePotion.toString(),
                lovePotion,
                ActionChoice.Icons.drink,
                "Drink LovePotion",//description?
                false),
                losePowerStartBattleNode);
        startBattle2Node.addChild(new ActionChoice(ChoiceLabels.AttackOpponentLovePotion.toString(),
                opponent,
                ActionChoice.Icons.lovepotion,
                "Attack Opponent LovePotion",//description?
                false),
                gainPowerStartBattleNode);
      
        var dungeonDoor2Node=new Node(NodeLabels.DungeonDoor2.toString());
        dungeonDoor2Node.addChild(new ActionChoice(ChoiceLabels.OpenDungeonDoor2.toString(),
                dungeon.getFurniture("Door"),
                ActionChoice.Icons.door,
                "Open Dungeon Door",
                false),
                startBattle2Node);
          
        var addHealingPotionNode=new Node(NodeLabels.AddHealingPotion.toString());
        addHealingPotionNode.addChild(new ActionChoice(ChoiceLabels.ExitAlchemyShop3.toString(),
                alchemyShop.getFurniture("Door"),
                ActionChoice.Icons.door,
                "Exit AlchemyShop with HealingPotion",
                false),
                dungeonDoor2Node);
          
        var healingPotionNode=new Node(NodeLabels.HealingPotion.toString());
        healingPotionNode.addChild(new ActionChoice(ChoiceLabels.AddToListHealingPotion.toString(),
                healingPotion,
                ActionChoice.Icons.healingpotion,
                "Add HealingPotion to list",
                false),
                addHealingPotionNode);
      
        var addLovePotionNode=new Node(NodeLabels.AddLovePotion.toString());
        addLovePotionNode.addChild(new ActionChoice(ChoiceLabels.ExitAlchemyShop2.toString(),
                alchemyShop.getFurniture("Door"),
                ActionChoice.Icons.door,
                "Exit AlchemyShop with LovePotion",
                false),
                dungeonDoor2Node);
      
        var lovePotionNode=new Node(NodeLabels.LovePotion.toString());
        lovePotionNode.addChild(new ActionChoice(ChoiceLabels.AddToListLovePotion.toString(),
                lovePotion,
                ActionChoice.Icons.lovepotion,
                "Add LovePotion to list",
                false),
                addLovePotionNode);
      
        var alchemyShopBarNode=new Node(NodeLabels.AlchemyShopBar.toString());
        alchemyShopBarNode.addChild(new ActionChoice(ChoiceLabels.GiveCoinsLovePotion.toString(),
                shopkeeper,
                ActionChoice.Icons.lovepotion,
                "Buying LovePotion",
                false),
                lovePotionNode);
        alchemyShopBarNode.addChild(new ActionChoice(ChoiceLabels.GiveCoinsHealingPotion.toString(),
                shopkeeper,
                ActionChoice.Icons.healingpotion,
                "Buying HealingPotion",
                false),
                healingPotionNode);
      
        var gainPowerChickenLegNode=new Node(NodeLabels.GainPowerChickenLeg.toString());
        gainPowerChickenLegNode.addChild(new ActionChoice(ChoiceLabels.ExitAlchemyShop1.toString(),
                alchemyShop.getFurniture("Door"),
                ActionChoice.Icons.door,
                "Exit AlchemyShop",
                true),
                dungeonDoor2Node);
      
        var losePowerChikenLegNode=new Node(NodeLabels.LosePowerChickenLeg.toString());//Die
        var chickenLegNode=new Node(NodeLabels.ChickenLeg.toString());
        chickenLegNode.addChild(new ActionChoice(ChoiceLabels.PutDownChickenLeg.toString(),
                alchemyShop.getFurniture("Cauldron"),
                ActionChoice.Icons.cancel,
                "Burn ChickenLeg",//"do not use ChickenLeg, burn it in cauldron"
                false),
                losePowerChikenLegNode);
        chickenLegNode.addChild(new ActionChoice(ChoiceLabels.DrinkChickenLeg.toString(),
                alchemyShop.getFurniture("Cauldron"),
                ActionChoice.Icons.drink,
                "Eat ChickenLeg",
                false),
                gainPowerChickenLegNode);
      
        var alchemyShopCauldronNode=new Node(NodeLabels.AlchemyShopCauldron.toString());
        alchemyShopCauldronNode.addChild(new ActionChoice(ChoiceLabels.CreateItemChickenLeg.toString(),
                alchemyShop.getFurniture("Cauldron"),
                ActionChoice.Icons.chickenleg,
                "Creating ChickenLeg",
                false),
                chickenLegNode);
      
        var alchemyShopDoorNode=new Node(NodeLabels.AlchemyShopDoor.toString());
        alchemyShopDoorNode.addChild(new ActionChoice(ChoiceLabels.WalkToCauldron.toString(),
                alchemyShop.getFurniture("Cauldron"),
                ActionChoice.Icons.cauldron,
                "Walk to cauldron",
                false),
                alchemyShopCauldronNode);
      
        alchemyShopDoorNode.addChild(new ActionChoice(ChoiceLabels.OpenAlchemyShopBar.toString(),
                alchemyShop.getFurniture("Bar"),
                ActionChoice.Icons.hand,
                "Open AlchemyShop Bar",
                false),
                alchemyShopBarNode);
      
      
        var coinsNode=new Node(NodeLabels.Coins.toString());
        coinsNode.addChild(new ActionChoice(ChoiceLabels.ExitStorage.toString(),
                storage.getFurniture("Door"),
                ActionChoice.Icons.exit,
                "Exit Storage",
                false),
                alchemyShopDoorNode);
      
       
        var DieNode1 = new Node(NodeLabels.Die.toString());
        var DieNode2 = new Node(NodeLabels.Die.toString());
        var DieNode3 = new Node(NodeLabels.Die.toString());
        var DieNode4 = new Node(NodeLabels.Die.toString());
        var WinNode = new Node(NodeLabels.Win.toString());
      
        var BattlePoisonNode = new Node(NodeLabels.BattlePoison.toString());
        var StartBattleNode = new Node(NodeLabels.StartBattle.toString());
      
        BattlePoisonNode.addChild(new ActionChoice(ChoiceLabels.PoisonAttack.toString(),
                opponent,
                ActionChoice.Icons.poison,
                "Attack opponent with poison",
                false),
                WinNode);
      
      
        BattlePoisonNode.addChild(new ActionChoice(ChoiceLabels.DrinkPoison.toString(),
                poison,
                ActionChoice.Icons.drink,
                "Drink poison",
                false),
                DieNode4);
      
        var BattleSwordNode = new Node(NodeLabels.BattleSword.toString());
        BattleSwordNode.addChild(new ActionChoice(ChoiceLabels.SwordAttack.toString(),
                opponent,
                ActionChoice.Icons.swords,
                "Attack opponent with sword",
                false),
                StartBattleNode);
          
        BattleSwordNode.addChild(new ActionChoice(ChoiceLabels.PutDownSword.toString(),
                sword,
                ActionChoice.Icons.cancel,
                "Drop sword",
                false),
                DieNode3);
      
        var BattleTorchNode = new Node(NodeLabels.BattleTorch.toString());
        BattleTorchNode.addChild(new ActionChoice(ChoiceLabels.TorchAttack.toString(),
                opponent,
                ActionChoice.Icons.firespell,
                "Cast firespell on opponent",
                false),
                StartBattleNode);
          
        BattleTorchNode.addChild(new ActionChoice(ChoiceLabels.TorchSelfAttack.toString(),
                mc,//have to change the object(cant click on the character), coordinate with sequence,
                ActionChoice.Icons.firespell,
                "Cast firespell on self",
                false),
                DieNode2);
      
        StartBattleNode.addChild(new ActionChoice(ChoiceLabels.PickUpTorch.toString(),
                torch,
                ActionChoice.Icons.torch,
                "Use torch",
                false),
                BattleTorchNode);
        StartBattleNode.addChild(new ActionChoice(ChoiceLabels.PickUpSword.toString(),
                sword,
                ActionChoice.Icons.draw,
                "Use swords",
                false),
                BattleSwordNode);
        StartBattleNode.addChild(new ActionChoice(ChoiceLabels.PickUpPoison.toString(),
                poison,
                ActionChoice.Icons.poison,
                "Use poison",
                false),
                BattlePoisonNode);
      
      
        var DungeonDoorNode = new Node(NodeLabels.DungeonDoor.toString());
        DungeonDoorNode.addChild(new ActionChoice(ChoiceLabels.OpenDungeonDoor.toString(),//OpenDungeonDoor added to ChoiceLabels
                dungeon.getFurniture("Door"),
                ActionChoice.Icons.door,
                "Open Dungeon Door",
                false),
                StartBattleNode);
      
      
        var AddPoisonNode = new Node(NodeLabels.AddPoison.toString());
        AddPoisonNode.addChild(new ActionChoice(ChoiceLabels.ExitPoison.toString(),
                dungeon.getFurniture("Door"),
                ActionChoice.Icons.door,
                "Exit poison and go to dungeon",
                false),
                DungeonDoorNode);
      
  //       AddPoisonNode.addChild(new SelectionChoice("ReturnPoison"), StorageChestNode);
      
      
        var PoisonNode = new Node(NodeLabels.Poison.toString());
        PoisonNode.addChild(new ActionChoice(ChoiceLabels.AddToList.toString(),
                poison,
                ActionChoice.Icons.poison,
                "Add poison to inventory",
                false),
                AddPoisonNode);
      
        PoisonNode.addChild(new ActionChoice(ChoiceLabels.Drink.toString(),
                poison,
                ActionChoice.Icons.drink,
                "Drink the poison",
                false),
                DieNode1);
      
      
        var EvilBookNode = new Node(NodeLabels.EvilBook.toString());
        EvilBookNode.addChild(new ActionChoice(ChoiceLabels.CreatePoison.toString(),
                evilBook,
                ActionChoice.Icons.poison,
                "Create poison",
                false),
                PoisonNode);
      
      
        var AddSwordNode = new Node(NodeLabels.AddSword.toString()); // ADD AddSword
        AddSwordNode.addChild(new ActionChoice(ChoiceLabels.ExitSword.toString(),
                dungeon.getFurniture("Door"),
                ActionChoice.Icons.door,
                "Exit the sword and go to dungeon",
                false),
                DungeonDoorNode);
      
  //       AddSwordNode.addChild(new SelectionChoice("ReturnSword"), StorageChestNode);//delete or make action
      
      
        var SwordNode = new Node(NodeLabels.Sword.toString());
        SwordNode.addChild(new ActionChoice(ChoiceLabels.AddToList.toString(),
                sword,
                ActionChoice.Icons.sword,
                "Add sword to inventory",
                false),
                AddSwordNode);
      
      
        var AddTorchNode = new Node(NodeLabels.AddTorch.toString());
        AddTorchNode.addChild(new ActionChoice(ChoiceLabels.ExitTorch.toString(), // ADD ExitTorch
                dungeon.getFurniture("Door"),
                ActionChoice.Icons.door,
                "Leave the torch and go to dungeon",
                false),
                DungeonDoorNode);
      
  //       AddTorchNode.addChild(new SelectionChoice("ReturnTorch"),StorageChestNode);//delete or make an action
          
        var TorchNode = new Node(NodeLabels.Torch.toString());
        TorchNode.addChild(new ActionChoice(ChoiceLabels.AddToList.toString(), // May need to create specific AddToList actions
                torch,
                ActionChoice.Icons.torch,
                "Add torch to inventory",
                false),
                AddTorchNode);
      
      
        var WoodpileNode = new Node(NodeLabels.Woodpile.toString());
        WoodpileNode.addChild(new ActionChoice(ChoiceLabels.CreateTorch.toString(),
                torch,///have to change, maybe the whole branch since no woodpile item
                ActionChoice.Icons.torch,
                "Create a torch from the woodpile",
                false),
                TorchNode);
      
        var storageChestNode =new Node(NodeLabels.StorageChest.toString());    
        storageChestNode.addChild(new ActionChoice(ChoiceLabels.PickUpWoodpile.toString(),
                storage.getFurniture("Chest"),
                ActionChoice.Icons.woodpile,
                "Pick up the woodpile",
                false),
                WoodpileNode);
      
        storageChestNode.addChild(new ActionChoice(ChoiceLabels.CollectSword.toString(), //ADD CollectSword
                storage.getFurniture("Chest"),
                ActionChoice.Icons.sword,
                "Collect the sword",
                false),
                SwordNode);
      
        storageChestNode.addChild(new ActionChoice(ChoiceLabels.LookAt.toString(),
                storage.getFurniture("Chest"),
                ActionChoice.Icons.research,
                "Research the EvilBook",
                false),
                EvilBookNode);
     
        storageChestNode.addChild(new ActionChoice(ChoiceLabels.PickUpCoins.toString(),
                storage.getFurniture("Chest"),
                ActionChoice.Icons.coins,
                "Pick up coins from Storage Chest",
                false),
                coinsNode);
      
        var storageNode = new Node(NodeLabels.Storage.toString());
        storageNode.addChild(new ActionChoice(
                "OpenFurniture",
                storage.getFurniture("Chest"),
                ActionChoice.Icons.chest,
                "Open Chest",
                false),
                storageChestNode);
      
        var startNode = new Node(NodeLabels.Start.toString());
        startNode.addChild(new PositionChoice(
                mc,
                "Ruins.Exit",
                PositionChoice.Condition.arrived),
                storageNode);
  
        
        var initNode = new Node(NodeLabels.Init.toString());
        initNode.addChild(new SelectionChoice("Start"), startNode);
                
        return initNode;
}


    public void getThings() {

        //Characters
        mc = new Character("john");
        opponent = new Character("Opponent name");

        coin = new Item(Items.Coin.toString(), Items.Coin);
        woodPile = new Item(Items.Woodpile.toString(), Items.Torch);
        torch = new Item(Items.Torch.toString(), Items.Torch);
        evilBook = new Item(Items.EvilBook.toString(), Items.EvilBook);
        chickenLeg = new Item(Items.ChickenLeg.toString(), Items.ChickenLeg);
        poison = new Item(Items.BluePotion.toString(), Items.BluePotion);
        healingPotion = new Item(Items.PurplePotion.toString(), Items.PurplePotion);
        sword = new Item(Items.Sword.toString(), Items.Sword);
        lovePotion = new Item(Items.RedPotion.toString(), Items.RedPotion);

        //Places
        ruins = new Place(Places.Ruins.toString(), Places.Ruins);
        alchemyShop = new Place(Places.AlchemyShop.toString(), Places.AlchemyShop);
        storage = new Place(Places.Storage.toString(), Places.Storage);
        dungeon = new Place(Places.Dungeon.toString(), Places.Dungeon);

    };

    private ActionSequence getLosePowerNodeSequence() {
        // Corresponds to node "losePowerStartBattleNode"
        var sequence = new ActionSequence();

        sequence.add(new DisableInput());
        sequence.add(new SetNarration("A sudden pain sears through you, sapping your strength."));
        sequence.add(new ShowNarration());
        sequence.add(new Wait(5));
        sequence.add(new HideNarration());
        sequence.add(new SetNarration("You feel your power waning."));
        sequence.add(new ShowNarration());
        sequence.add(new Wait(5));
        sequence.add(new HideNarration());
        sequence.add(new EnableInput());

        return sequence;
    }

    private ActionSequence getLosePowerChickenLegNodeSequence() {
        // Corresponds to node "losePowerChickenLegNode"
        var sequence = new ActionSequence();

        sequence.add(new DisableInput());
        sequence.add(new SetNarration("Something was off about that chicken leg. You begin to feel weak."));
        sequence.add(new ShowNarration());
        sequence.add(new Wait(5));
        sequence.add(new HideNarration());
        sequence.add(new SetNarration("You feel your power waning."));
        sequence.add(new ShowNarration());
        sequence.add(new Wait(5));
        sequence.add(new HideNarration());
        sequence.add(new EnableInput());

        return sequence;
    }

    private ActionSequence getGainPowerChickenLegNodeSequence() {
        // Corresponds to node "gainPowerChickenLegNode"
        var sequence = new ActionSequence();

        sequence.add(new DisableInput());
        sequence.add(new SetNarration("You feel stronger after eating the chicken leg."));
        sequence.add(new ShowNarration());
        sequence.add(new Wait(5));
        sequence.add(new HideNarration());
        sequence.add(new SetNarration("You feel your power increasing."));
        sequence.add(new ShowNarration());
        sequence.add(new Wait(5));
        sequence.add(new HideNarration());
        sequence.add(new EnableInput());

        return sequence;
    }


    private ActionSequence getStartBattle2NodeSequence() {
        // Corresponds to node "startBattle2Node"
        var sequence = new ActionSequence();

        sequence.add(new DisableInput());
        sequence.add(new SetNarration("An ominous feeling overcomes the room as the player grips the sword tightly."));
        sequence.add(new ShowNarration());
        sequence.add(new Wait(5));
        sequence.add(new HideNarration());
        sequence.add(new Draw(mc, sword));
        sequence.add(new WalkTo(mc, dungeon.getFurniture("Door")));
        sequence.add(new Face(mc, opponent));
        sequence.add(new Wait(1000));
        sequence.add(new SetNarration("This is it... the moment of truth."));
        sequence.add(new ShowNarration());
        sequence.add(new Wait(5));
        sequence.add(new HideNarration());
        sequence.add(new EnableInput());

        return sequence;
    }

    private ActionSequence getDungeonDoor2NodeSequence() {
        // Corresponds to node "dungeonDoor2Node"
        var sequence = new ActionSequence();

        sequence.add(new DisableInput());
        sequence.add(new SetNarration("The heavy door stands before you, echoing the dangers that lurk beyond."));
        sequence.add(new ShowNarration());
        sequence.add(new Wait(5));
        sequence.add(new HideNarration());
        sequence.add(new Wait(1000));
        sequence.add(new SetNarration("With a deep breath, you step through, ready for battle."));
        sequence.add(new ShowNarration());
        sequence.add(new Wait(5));
        sequence.add(new HideNarration());
        sequence.add(new EnableInput());

        return sequence;
    }

    private ActionSequence getAddHealingPotionNodeSequence() {
        // Corresponds to node "addHealingPotionNode"
        var sequence = new ActionSequence();

        sequence.add(new DisableInput());
        sequence.add(new Give(mc, coin, shopkeeper));
        sequence.add(new Pocket(shopkeeper, coin));
        sequence.add(new Unpocket(shopkeeper, healingPotion));
        sequence.add(new Give(shopkeeper, healingPotion, mc));
        sequence.add(new Pocket(mc, lovePotion));
        sequence.add(new Wait(5));
        sequence.add(new AddToList(healingPotion)); 
        sequence.add(new SetNarration("This may come in handy when the time is right."));
        sequence.add(new ShowNarration());
        sequence.add(new Wait(5));
        sequence.add(new HideNarration());
        sequence.add(new EnableInput());

        return sequence;
    }

    private ActionSequence getHealingPotionNodeSequence() {
        // Corresponds to node "healingPotionNode"
        var sequence = new ActionSequence();

        sequence.add(new DisableInput());
        sequence.add(new SetNarration("They don't sell these much anymore. Better save it."));
        sequence.add(new ShowNarration());
        sequence.add(new Wait(5));
        sequence.add(new HideNarration());
        sequence.add(new EnableInput());
        

        return sequence;
    }

    private ActionSequence getAddLovePotionNodeSequence() {
        // Corresponds to node "addLovePotionNode"
        var sequence = new ActionSequence();
    
        sequence.add(new DisableInput());
        sequence.add(new Give(mc, coin, shopkeeper));
        sequence.add(new Pocket(shopkeeper, coin));
        sequence.add(new Unpocket(shopkeeper, lovePotion));
        sequence.add(new Give(shopkeeper, lovePotion, mc));
        sequence.add(new Pocket(mc, lovePotion));
        sequence.add(new Wait(5));
        sequence.add(new AddToList(lovePotion)); 
        sequence.add(new SetNarration("With a love potion in hand, the possibilities are endless."));
        sequence.add(new ShowNarration());
        sequence.add(new Wait(5));
        sequence.add(new HideNarration());
        sequence.add(new EnableInput());
    
        return sequence;
    }
    
    private ActionSequence getLovePotionNodeSequence() {
        // Corresponds to node "lovePotionNode"
        var sequence = new ActionSequence();
    
        sequence.add(new DisableInput());
        sequence.add(new SetNarration("The allure of the love potion is tempting."));
        sequence.add(new ShowNarration());
        sequence.add(new Wait(5));
        sequence.add(new HideNarration());
        sequence.add(new EnableInput());
    
        return sequence;
    }
    

    private ActionSequence getAlchemyShopBarNodeSequence() {
        // Corresponds to node "alchemyShopBarNode"
        var sequence = new ActionSequence();

        sequence.add(new DisableInput());
        sequence.add(new SetNarration("The bar is lined with an array of exotic potions and ingredients."));
        sequence.add(new ShowNarration());
        sequence.add(new Wait(5));
        sequence.add(new HideNarration());
        sequence.add(new WalkTo(mc, alchemyShop.getFurniture("Bar")));
        sequence.add(new Wait(5));
        sequence.add(new SetNarration("Shopkeeper: Can I interest you in some of our finest potions?"));
        sequence.add(new ShowNarration());
        sequence.add(new Wait(5));
        sequence.add(new HideNarration());
        sequence.add(new EnableInput());

        return sequence;
    }

    private ActionSequence getGainPowerNodeSequence() {
        // Corresponds to node "gainPowerNode"
        var sequence = new ActionSequence();

        sequence.add(new DisableInput());
        sequence.add(new SetNarration("You feel clear minded and strong. Power coarses through your blood."));
        sequence.add(new ShowNarration());
        sequence.add(new Wait(5));
        sequence.add(new HideNarration());
        sequence.add(new SetNarration("You feel your power increasing."));
        sequence.add(new ShowNarration());
        sequence.add(new Wait(5));
        sequence.add(new HideNarration());
        sequence.add(new EnableInput());

        return sequence;
    }

    private ActionSequence getChickenLegNodeSequence() {
        // Corresponds to node "chickenLegNode"
        var sequence = new ActionSequence();


        return sequence;
    }

    private ActionSequence getAlchemyShopCauldronNodeSequence() {
        // Corresponds to node "alchemyShopCauldronNode"
        var sequence = new ActionSequence();

        sequence.add(new OpenFurniture(mc, alchemyShop.getFurniture("Cauldron")));
        sequence.add(new Pickup(mc, chickenLeg));

        return sequence;
    }

    private ActionSequence getAlchemyShopDoorNodeSequence() {
        // Corresponds to node "alchemyShopDoorNode"
        var sequence = new ActionSequence();

        sequence.add(new DisableInput());
        sequence.add(new Exit(mc, ruins.getFurniture("Door"))); //IF THIS IS INCORRECT, IT NEEDS TO BE REPLACED BY STORAGE.DOOR AS DO OTHER INSTANCES OF ruins.xyz
        sequence.add(new Enter(mc, alchemyShop));
        sequence.add(new EnableInput());
        sequence.add(new SetPosition(shopkeeper, alchemyShop.getFurniture("Table")));

        return sequence;
    }

    private ActionSequence getCoinsNodeSequence() {
        // Corresponds to node "coinsNode"
        var sequence = new ActionSequence();

        sequence.add(new DisableInput());
        sequence.add(new Pickup(mc, coin, ruins.getFurniture("Chest")));
        sequence.add(new EnableInput());

        return sequence;
    }

    private ActionSequence getStorageChestNodeSequence() {
        // Corresponds to node "storageChestNode"
        var sequence = new ActionSequence();

        sequence.add(new SetNarration("Chests contain useful tools that will help you on your quest!"));
        sequence.add(new ShowNarration());


        return sequence;
    }

    private ActionSequence getStorageNodeSequence() {
        // Corresponds to node "storageNode"
        var sequence = new ActionSequence();

        sequence.add(new DisableInput());
        sequence.add(new Enter(mc, storage.getFurniture("Door")));
        sequence.add(new EnableInput());

        return sequence;
    }

    private ActionSequence getStartNodeSequence() {
        // Corresponds to node "startNode"
        var sequence = new ActionSequence();

        sequence.add(new ShowMenu(false)); //THIS LINE
        sequence.add(new Position(mc, ruins, "Chest"));
        sequence.add(new SetCameraFocus(mc));
        sequence.add(new EnableInput());

        return sequence;
    }

    private ActionSequence getRootSequence() {
        // Corresponds to node "root"
        var sequence = new ActionSequence();
        return sequence;
    }

    private ActionSequence getPoisonNodeSequence() {
        // Corresponds to node "PoisonNode"
        var sequence = new ActionSequence();

        sequence.add(new DisableInput());
        sequence.add(new AddToList(poison)); 
        sequence.add(new SetNarration("What have I done? The poison is now in my possession."));
        sequence.add(new ShowNarration());
        sequence.add(new Wait(5));
        sequence.add(new HideNarration());
        sequence.add(new EnableInput());

        return sequence;
    }

    private ActionSequence getSwordNodeSequence() {
        // Corresponds to node "SwordNode"
        var sequence = new ActionSequence();

        sequence.add(new DisableInput());
        sequence.add(new Pickup(mc, sword));
        sequence.add(new SetNarration("You have obtained a sword; its edge promises defense and danger alike."));
        sequence.add(new ShowNarration());
        sequence.add(new Wait(5));
        sequence.add(new HideNarration());
        sequence.add(new EnableInput());

        return sequence;
    }

    private ActionSequence getTorchNodeSequence() {
        // Corresponds to node "TorchNode"
        var sequence = new ActionSequence();
        
        sequence.add(new DisableInput());
        sequence.add(new Wait(5));
        sequence.add(new SetNarration("The torch flickers to life, casting a warm glow."));
        sequence.add(new ShowNarration());
        sequence.add(new Wait(5));
        sequence.add(new HideNarration());
        sequence.add(new EnableInput());

        return sequence;
    }

    private ActionSequence getStartBattleNodeSequence() {
        // Corresponds to node "StartBattleNode"
        var sequence = new ActionSequence();

        sequence.add(new DisableInput());
        sequence.add(new SetNarration("An ominous feeling overcomes the room as the player grips the sword tightly."));
        sequence.add(new ShowNarration());
        sequence.add(new Wait(5));
        sequence.add(new HideNarration());
        sequence.add(new Draw(mc, sword));
        sequence.add(new WalkTo(mc, dungeon.getFurniture("Door")));
        sequence.add(new Face(mc, opponent));
        sequence.add(new Wait(1000));
        sequence.add(new SetNarration("This is it... the moment of truth."));
        sequence.add(new ShowNarration());
        sequence.add(new Wait(5));
        sequence.add(new HideNarration());
        sequence.add(new EnableInput());

        return sequence;
    }

    private ActionSequence getDungeonDoorNodeSequence() {
        // Corresponds to node "DungeonDoorNode"
        var sequence = new ActionSequence();

        sequence.add(new DisableInput());
        sequence.add(new SetNarration("The heavy door stands before you, echoing the dangers that lurk beyond."));
        sequence.add(new ShowNarration());
        sequence.add(new Wait(5));
        sequence.add(new HideNarration());
        sequence.add(new Wait(1000));
        sequence.add(new SetNarration("With a deep breath, you step through, ready for battle."));
        sequence.add(new ShowNarration());
        sequence.add(new Wait(5));
        sequence.add(new HideNarration());
        sequence.add(new EnableInput());


        return sequence;
    }

    private ActionSequence getAddPoisonNodeSequence() {
        // Corresponds to node "AddPoisonNode"
        var sequence = new ActionSequence();

        sequence.add(new DisableInput());
        sequence.add(new SetNarration("With a sense of foreboding, the player opens the evil book to a marked page."));
        sequence.add(new ShowNarration());
        sequence.add(new Wait(5));
        sequence.add(new HideNarration());
        sequence.add(new SetNarration("The air thickens as a dark concoction brews."));
        sequence.add(new ShowNarration());
        sequence.add(new Wait(5));
        sequence.add(new HideNarration());
        sequence.add(new RemoveFromList(evilBook));
        sequence.add(new EnableInput());

        return sequence;
    }

    private ActionSequence getEvilBookNodeSequence() {
        // Corresponds to node "EvilBookNode"
        var sequence = new ActionSequence();

        sequence.add(new DisableInput());
        sequence.add(new SetNarration("Tucked away in the chest, a book bound in shadows catches your eye."));
        sequence.add(new ShowNarration());
        sequence.add(new Wait(5));
        sequence.add(new HideNarration());
        sequence.add(new Pickup(mc, evilBook));
        sequence.add(new SetNarration("This tome... it's filled with forbidden knowledge."));
        sequence.add(new ShowNarration());
        sequence.add(new Wait(5));
        sequence.add(new EnableInput());
        
        return sequence;
    }

    private ActionSequence getAddSwordNodeSequence() {
        // Corresponds to node "AddSwordNode"
        var sequence = new ActionSequence();

        sequence.add(new DisableInput());
        sequence.add(new AddToList(sword)); // Adds the sword to the inventory
        sequence.add(new SetNarration("The sword's weight feels reassuring in your grip."));
        sequence.add(new ShowNarration());
        sequence.add(new Wait(5));
        sequence.add(new HideNarration());
        sequence.add(new EnableInput());

        return sequence;
    }

    private ActionSequence getAddTorchNodeSequence() {
        // Corresponds to node "AddTorchNode"
        var sequence = new ActionSequence();

        sequence.add(new DisableInput());
        sequence.add(new Pickup(mc, torch));
        sequence.add(new AddToList(torch)); 
        sequence.add(new SetNarration("It's always good to have a torch in this dark world."));
        sequence.add(new ShowNarration());
        sequence.add(new Wait(5));
        sequence.add(new HideNarration());
        sequence.add(new EnableInput());

        return sequence;
    }

    private ActionSequence getBattleSwordSequence() {
        var sequence = new ActionSequence();

        sequence.add(new DisableInput());
        sequence.add(new Draw(mc, sword));
        sequence.add(new SetNarration("You draw your sword, steeling yourself for the battle ahead."));
        sequence.add(new ShowNarration());
        sequence.add(new Wait(5));
        sequence.add(new HideNarration());
        sequence.add(new EnableInput());

        return sequence;
    }

    private ActionSequence getBattleTorchSequence() {
        var sequence = new ActionSequence();

        sequence.add(new DisableInput());
        sequence.add(new Draw(mc, torch));
        sequence.add(new SetNarration("You light the torch, its flames casting a flickering light and promising fiery retribution."));
        sequence.add(new ShowNarration());
        sequence.add(new Wait(5));
        sequence.add(new HideNarration());
        sequence.add(new EnableInput());

        return sequence;
    }

    private ActionSequence getWoodpileNodeSequence() {
        // Corresponds to node "WoodPileNode"
        var sequence = new ActionSequence();
        return sequence;
    }

    private ActionSequence getinitNodeSequence() {
        // Corresponds to node "initNode"
        var sequence = new ActionSequence();

        sequence.combineWith(new CharacterCreation(mc));

        sequence.add(new Create<Character>(opponent));
        sequence.add(new Create<Item>(coin));
        sequence.add(new Create<Item>(woodPile));
        sequence.add(new Create<Item>(torch));
        sequence.add(new Create<Item>(evilBook));
        sequence.add(new Create<Item>(chickenLeg));
        sequence.add(new Create<Item>(poison));
        sequence.add(new Create<Item>(healingPotion));
        sequence.add(new Create<Item>(sword));
        sequence.add(new Create<Item>(lovePotion));
        sequence.add(new Create<Place>(ruins));
        sequence.add(new Create<Place>(alchemyShop));
        sequence.add(new Create<Place>(storage));
        sequence.add(new Create<Place>(dungeon));
        sequence.add(new ShowMenu(true));


        return sequence;
    }

    private ActionSequence getBattlePoisonSequence() {
        // Corresponds to node "DieNode"
        var sequence = new ActionSequence();

        sequence.add(new DisableInput());
        sequence.add(new Draw(mc, poison));
        sequence.add(new SetNarration("Be careful! Poison can hurt you as much as your opponent."));
        sequence.add(new ShowNarration());
        sequence.add(new Wait(5));
        sequence.add(new HideNarration());
        sequence.add(new EnableInput());

        return sequence;
    }

    private ActionSequence getDieNodeSequence() {
        // Corresponds to node "DieNode"
        var sequence = new ActionSequence();

        sequence.add(new DisableInput());
        sequence.add(new SetNarration("Your vision fades as you succumb to your wounds..."));
        sequence.add(new ShowNarration());
        sequence.add(new Wait(5));
        sequence.add(new FadeOut());
        sequence.add(new Wait(1000));
        sequence.add(new SetNarration("You have died."));
        sequence.add(new ShowNarration());
        sequence.add(new Wait(5));
        sequence.add(new HideNarration());
        sequence.add(new Reset()); 
        sequence.add(new ShowMenu(true));
        sequence.add(new EnableInput());

        return sequence;
    }

    private ActionSequence getWinNodeSequence() {
        // Corresponds to node "WinNode"
        var sequence = new ActionSequence();

        sequence.add(new DisableInput());
        sequence.add(new SetNarration("Victory is yours! The enemy lies defeated at your feet."));
        sequence.add(new ShowNarration());
        sequence.add(new Wait(5));
        sequence.add(new FadeIn());
        sequence.add(new SetNarration("You have won the battle."));
        sequence.add(new ShowNarration());
        sequence.add(new Wait(5));
        sequence.add(new HideNarration());
        sequence.add(new ShowMenu(true));
        sequence.add(new EnableInput());

        return sequence;
    }


}

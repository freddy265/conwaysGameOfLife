package regles;

import java.util.TreeMap;

import regles.circuit.ColorBootstrap;
import regles.circuit.CyclicSpirals;
import regles.circuit.FossilDebris;
import regles.circuit.Imperfect;
import regles.circuit.LavaLamp;
import regles.circuit.Perfect;
import regles.circuit.R313;
import regles.circuit.TurbulentPhase;
import regles.generation.Banners;
import regles.generation.BelZhab;
import regles.generation.BelZhabSediment;
import regles.generation.Bloomerang;
import regles.generation.Bombers;
import regles.generation.Brain6;
import regles.generation.BriansBrain;
import regles.generation.Burst;
import regles.generation.BurstII;
import regles.generation.Caterpillars;
import regles.generation.Chenille;
import regles.generation.Cooties;
import regles.generation.EbbAndFlow;
import regles.generation.EbbAndFlowII;
import regles.generation.Faders;
import regles.generation.Fireworks;
import regles.generation.FlamingStarbows;
import regles.generation.Frogs;
import regles.generation.FrozenSpirals;
import regles.generation.Glisserati;
import regles.generation.Glissergy;
import regles.generation.Lava;
import regles.generation.Lines;
import regles.generation.LinesOnTheEdge;
import regles.generation.MeteorGuns;
import regles.generation.Nova;
import regles.generation.OrthoGo;
import regles.generation.PrairieOnfire;
import regles.generation.RainZha;
import regles.generation.Rake;
import regles.generation.SediMental;
import regles.generation.Snake;
import regles.generation.SoftFreeze;
import regles.generation.Spirals;
import regles.generation.StarWars;
import regles.generation.Sticks;
import regles.generation.Swirl;
import regles.generation.ThrillGrill;
import regles.generation.Transers;
import regles.generation.TransersII;
import regles.generation.Wanderers;
import regles.generation.Worms;
import regles.generation.Xtasy;
import regles.vie.Amoeba;
import regles.vie.Move;
import regles.vie.R2x2;
import element.Cell;
import element.IFabrique;
import element.Regles;
import famille.cell.CellCircuit;
import famille.cell.CellGeneration;
import famille.cell.CellVie;

public class FabriqueCellRegle implements IFabrique {

	private TreeMap<String, Cell> prototypes = new TreeMap<String, Cell>();

	public FabriqueCellRegle() {
		this.add("Amoeba", (new CellVie(1, new Amoeba())));
		this.add("Amoeba2", (new CellVie(1, new Amoeba())));
		this.add("Move", (new CellVie(1, new Move())));
		this.add("R2x2", (new CellVie(1, new R2x2())));
		this.add("FossilDebris", (new CellCircuit(new FossilDebris())));
		this.add("LavaLamp", (new CellCircuit(new LavaLamp())));
		this.add("Snake", (new CellGeneration(new Snake())));
		this.add("Spirals", (new CellGeneration(new Spirals())));
		this.add("Bombers", (new CellGeneration(new Bombers())));
		this.add("Xtasy", (new CellGeneration(new Xtasy())));
		this.add("ThrillGrill", (new CellGeneration(new ThrillGrill())));
		this.add("Worms", (new CellGeneration(new Worms())));
		this.add("StarWars", (new CellGeneration(new StarWars())));
		this.add("Lines", (new CellGeneration(new Lines())));
		this.add("Banners", (new CellGeneration(new Banners())));
		this.add("BelZhab", (new CellGeneration(new BelZhab())));
		this.add("BelZhabSediment", (new CellGeneration(new BelZhabSediment())));
		this.add("Bloomerang", (new CellGeneration(new Bloomerang())));
		this.add("Brain6", (new CellGeneration(new Brain6())));
		this.add("BriansBrain", (new CellGeneration(new BriansBrain())));
		this.add("Burst", (new CellGeneration(new Burst())));
		this.add("BurstII", (new CellGeneration(new BurstII())));
		this.add("Caterpillars", (new CellGeneration(new Caterpillars())));
		this.add("Chenille", (new CellGeneration(new Chenille())));
		this.add("Cooties", (new CellGeneration(new Cooties())));
		this.add("EbbAndFlow", (new CellGeneration(new EbbAndFlow())));
		this.add("EbbAndFlowII", (new CellGeneration(new EbbAndFlowII())));
		this.add("Faders", (new CellGeneration(new Faders())));
		this.add("Fireworks", (new CellGeneration(new Fireworks())));
		this.add("FlamingStarbows", (new CellGeneration(new FlamingStarbows())));
		this.add("Frogs", (new CellGeneration(new Frogs())));
		this.add("FrozenSpirals", (new CellGeneration(new FrozenSpirals())));
		this.add("Glisserati", (new CellGeneration(new Glisserati())));
		this.add("Glissergy", (new CellGeneration(new Glissergy())));
		this.add("Lava", (new CellGeneration(new Lava())));
		this.add("LinesOnTheEdge", (new CellGeneration(new LinesOnTheEdge())));
		this.add("MeteorGuns", (new CellGeneration(new MeteorGuns())));
		this.add("Nova", (new CellGeneration(new Nova())));
		this.add("OrthoGo", (new CellGeneration(new OrthoGo())));
		this.add("PrairieOnfire", (new CellGeneration(new PrairieOnfire())));
		this.add("RainZha", (new CellGeneration(new RainZha())));
		this.add("Rake", (new CellGeneration(new Rake())));
		this.add("SediMental", (new CellGeneration(new SediMental())));
		this.add("SoftFreeze", (new CellGeneration(new SoftFreeze())));
		this.add("Sticks", (new CellGeneration(new Sticks())));
		this.add("Swirl", (new CellGeneration(new Swirl())));
		this.add("Transers", (new CellGeneration(new Transers())));
		this.add("TransersII", (new CellGeneration(new TransersII())));
		this.add("Wanderers", (new CellGeneration(new Wanderers())));
		this.add("R313", (new CellCircuit(new R313())));
		this.add("ColorBootstrap", (new CellCircuit(new ColorBootstrap())));
		this.add("CyclicSpirals", (new CellCircuit(new CyclicSpirals())));
		this.add("Imperfect", (new CellCircuit(new Imperfect())));
		this.add("Perfect", (new CellCircuit(new Perfect())));
		this.add("TurbulentPhase", (new CellCircuit(new TurbulentPhase())));

	}

	protected void add(String s, Cell c) {
		prototypes.put(s, c);
	}

	@Override
	public String[] getTypes() {
		return prototypes.keySet().toArray(new String[0]);
	}

	@Override
	public Cell create(String regleChoisie) {
		return prototypes.get(regleChoisie).clone();
	}

	@Override
	public Regles getRegle(String regleChoisie) {
		
		return prototypes.get(regleChoisie).clone().getRegle();
	}

}

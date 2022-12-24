package model.data;

import java.io.Serializable;
import java.util.List;

public class Game implements Serializable {
	final private int maxUserHP = 10;
	final private int healVal = 2;
	final private int[] enemyAttack = {1,2,4,5};
	final private int[] sucoreRate = {10,15,20,30};
	
	final private List<Question> questionList;
	private int hp;
	private int qCnt;
	private int enemyCnt;
	private int maxCombo;
	private int combo;
	
	public Game(List<Question> questionList) {
		super();
		this.questionList = questionList;
		this.hp = maxUserHP;
		this.qCnt = 0;
		this.enemyCnt = 0;
		this.maxCombo = 0;
		this.combo = 0;
	}
	
	public void userAttack() {
		this.enemyCnt++;
		this.combo++;
		if(combo>maxCombo) {
			maxCombo = combo;
		}
	}
	
	public void userheal() {
		this.hp += healVal;
		if(hp>maxUserHP) {
			hp=maxUserHP;
		}
	}
	
	public void enemyAttack(int lebel) {
		hp -= enemyAttack[lebel];
	}
	
	public void qCntUp() {
		qCnt++;
	}

	public int getMaxUserHP() {
		return maxUserHP;
	}

	public int gethealVal() {
		return healVal;
	}

	public int[] getEnemyAttack() {
		return enemyAttack;
	}

	public int[] getSucoreRate() {
		return sucoreRate;
	}

	public List<Question> getQuestionList() {
		return questionList;
	}

	public int getHp() {
		return hp;
	}

	public int getqCnt() {
		return qCnt;
	}

	public int getEnemyCnt() {
		return enemyCnt;
	}

	public int getMaxCombo() {
		return maxCombo;
	}

	public int getCombo() {
		return combo;
	}
	
}

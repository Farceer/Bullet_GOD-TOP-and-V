
public class Character {
	private int hp;
	private int remainingShot;
	private int shotSpeed;
	private int moveSpeed;
	private int remainingMove;
	private boolean isDead;
	private int position_x;
	private int position_y;
	
	
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getRemainingShot() {
		return remainingShot;
	}
	public void setRemainingShot(int remainingShot) {
		this.remainingShot = remainingShot;
	}
	public int getShotSpeed() {
		return shotSpeed;
	}
	public void setShotSpeed(int shotSpeed) {
		this.shotSpeed = shotSpeed;
	}
	public int getMoveSpeed() {
		return moveSpeed;
	}
	public void setMoveSpeed(int moveSpeed) {
		this.moveSpeed = moveSpeed;
	}
	public int getRemainingMove() {
		return remainingMove;
	}
	public void setRemainingMove(int remainingMove) {
		this.remainingMove = remainingMove;
	}
	public boolean isDead() {
		return isDead;
	}
	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}
	public int getPosition_x() {
		return position_x;
	}
	public void setPosition_x(int position_x) {
		this.position_x = position_x;
	}
	public int getPosition_y() {
		return position_y;
	}
	public void setPosition_y(int position_y) {
		this.position_y = position_y;
	}
	
	
	
	public Character(int pos_x,int pos_y)
	{
		position_x=pos_x;
		position_y=pos_y;
	}
	
}

# Prog_meth_Team_TOP-Velody
🍻🍺🍺🍺🍻🍻🍺🍺🍺งานเป็นสิ่งสำคัญ เหล้าก็เป็นเหมือนเพื่อนยามเหงา และคะแนนเป็นแค่สิ่งที่ทำให้ชีวิตนั้นสนุก🍺🍻🍻🍻🍺🍺🍻🍺🍻
.
.
.
.
.
.
พอๆ ไอสัส 

งานของเราจะเป็น เกมไพ่ธรรมดาที่ปรับเปลี่ยน และโคตร manual เหิ้ยๆ  🍌🍌🍌🍌  ทุกอย่างทำเอง 

🙌🙌🙌🙌🙌ข้อตกลงคือ🙌🙌🙌🙌🙌
🤣🤣🤣🤣🤣🤣🤣
Commit ต้องเป็นแนวนี้  ชื่อ -> งานที่ทำ  -> ปรับเปลี่ยนอะไรไป -> Code ที่ปรับ 
เช่น  TOP-งานที่ทำ->ลองสร้าง DEMO class -> เติม class ลง Eclipse -> ///// code ////// ;
ขอไม่ -m นะ ส่งเป็น แนบใน Vs หรือ SupLime 😍😍😍😍😍😍
🤣🤣🤣🤣🤣🤣🤣

//////////////////////////////////////// Clean code lke this////////////////////////////////////////
import javafx.scene.shape.Rectangle;

public class Bullet {
	

	private Rectangle Bullet ; 
	private double X_axis ; 
	private double Y_axis ; 
	private int Direction ; 
	public final static int BULLETSPEED = 10 ; 
	
	// Gonna to setup for nwe picture 
	
	public Bullet(Rectangle bullet,double X_axis,double Y_axis,int Direction) {
		super();
		this.Bullet = new Rectangle();
		this.Bullet.setX(X_axis );this.Bullet.setY( Y_axis);
		this.Bullet.setHeight(20);this.Bullet.setWidth(20);
		this.Direction  = 0 ; 
	}
	
	public  int directionMove() {
		if ( getDirection() >= 0 ) {
			return BULLETSPEED ;
		}else {
			return -1*BULLETSPEED ;
		}
	}
	
	public void update() {
		getBullet().setX(getX_axis()+directionMove());
	}
	public Rectangle getBullet() {
		return this.Bullet;
	}

	public double getX_axis() {
		return this.X_axis;
	}

	public double getY_axis() {
		return this.Y_axis;
	}

	public int getDirection() {
		return this.Direction;
	}


	public void setX_axis(double x_axis) {
		this.Bullet.setX(x_axis) ; 
		this.X_axis = x_axis ; 
	}

	public void setY_axis(double y_axis) {
		this.Bullet.setY(y_axis) ;
		this.Y_axis = y_axis;
	}

	public void setDicection(int direction) {
		if (direction < 0) { direction = -1 ; }
		else {direction = 1 ;}
		this.Direction = direction;
	}
	//////////////////////////////////////// Clean code lke this////////////////////////////////////////


public class ball {
	public int bx, by , bw , bh, Vx,Vy;

	
	public ball(int bx , int by, int bw, int bh, int Vx,int Vy){
		this.bx=bx;
		this.by=by;
		this.bw=bw;
		this.bh=bh;
		this.Vx=Vx;
		this.Vy=Vy;
	}

	public int getBw() {
		return bw;
	}

	public void setBw(int bw) {
		this.bw = bw;
	}

	public int getBh() {
		return bh;
	}

	public void setBh(int bh) {
		this.bh = bh;
	}

	public int getBx() {
		return bx;
	}

	public void setBx(int bx) {
		this.bx = bx;
	}

	public int getBy() {
		return by;
	}

	public void setBy(int by) {
		this.by = by;
	}

	public int getVx() {
		return Vx;
	}

	public void setVx(int vx) {
		Vx = vx;
	}
	public int getVy() {
		return Vy;
	}

	public void setVy(int vy) {
		Vy = vy;
	}
}

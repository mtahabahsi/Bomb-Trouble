
public class move extends baba {
	public int ivme = 1;
	
	
	public void hareket() {
		ball b = new ball(350,55,60,60,1,-5);
		toplar.add(b);
		while (true) {
			if(countball==1)
			hareketball();
			try{
				Thread.sleep(50);
				
			}
			catch(InterruptedException ex){}
		}
	}
	public void hareketball(){
		for (int i = 0; i < toplar.size(); i++){
		if (toplar.get(i).getVx() == -1) {
			if (toplar.get(i).getBx() < 688) {
				toplar.get(i).setBx(toplar.get(i).getBx()+4);
			}

			if (toplar.get(i).getBx() >= 688-toplar.get(i).getBw())
				toplar.get(i).setVx(1);
		}
		if (toplar.get(i).getVx() == 1) {
			if (toplar.get(i).getBx() >= -10) {
				toplar.get(i).setBx(toplar.get(i).getBx()-4);
			}
			if (toplar.get(i).getBx() <= 0)
				toplar.get(i).setVx(-1);
		}
		// ------


		toplar.get(i).setVy(toplar.get(i).getVy()+ivme);
		toplar.get(i).setBy((toplar.get(i).getBy()+toplar.get(i).getVy()));

		if (toplar.get(i).getBy()  >= 368-toplar.get(i).getBw() ) {
			toplar.get(i).setBy((368-toplar.get(i).getBw())-1);
			if(toplar.get(i).getBw()==60)
			toplar.get(i).setVy(-23);
			if(toplar.get(i).getBw()==30)
				toplar.get(i).setVy(-20);
			if(toplar.get(i).getBw()==15)
				toplar.get(i).setVy(-17);
			if(toplar.get(i).getBw()==7)
				toplar.get(i).setVy(-14);
		}
		}
	}
}

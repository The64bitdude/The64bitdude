package allgamesinone;
import java.util.Scanner;
public class physics {

		public void physicsc() {
			Scanner in = new Scanner(System.in);
			boolean we = true;
			while(we != false) {
			System.out.print("Vf :: ");
			double Vf = in.nextDouble();
			System.out.print("Vo :: ");
			double Vo = in.nextDouble();
			System.out.print("a :: ");
			double a = in.nextDouble();
			System.out.print("dx :: ");
			double dx = in.nextDouble();
			System.out.print("t :: ");
			double t = in.nextDouble();
			double op = 0;
			double ob = 0;
			int u = 0;
			double ada = 0;
			double y = 1;
			int r = 1;
			System.out.print("What is missing 1-5 :: ");
			int m = in.nextInt();
			System.out.print("What do you want 1-5 :: ");
			int x = in.nextInt();
			while(y == 1) {
			if(m == 1) {
		        if(x == 2) {
		        Vo = (dx - ((0.5)*(a)*(t*t)))/t;
		        Vf = (dx + ((0.5)*(a)*(t*t)))/t;
				}
		        if(x == 3) {
		        	a=(-2*((Vo*t) - dx))/(t*t);
		    		Vf = Vo + (a * t);
				}
		        if(x == 4) {
		        	dx = (Vo*t)+((0.5)*(a)*(t * t));	
		        	Vf = Vo + (a * t);
				}
		        if(x == 5) {
		        	if((dx < 0)&&(a<0)) {
		        		u = -1;
		        	}
		        	
		        		ada = ((Vo * Vo)+((4)*(0.5*a)*(dx)));
		        	
		        	if(ada < 0) {
		        		u = -1;
		        		ada = ada * -1;
		        	}
		        	Vf = java.lang.Math.sqrt(ada);
		        	 if((Vf > 0)&&(Vf < 0.00001)) {
			             	Vf = 0;
			             }
			             else if ((Vf < 0)&&(Vf > -0.00001)) {
			             	Vf = 0;
			             }
		        	 if(u < 0) {
		        		 Vf = Vf * u;
			        	}
	            	t = (Vf - Vo) / a;
	            	u = 1;
	            	ada = 0;
		        }
			}
	        if(m == 2) {
	            if(x == 1) {
	            	Vo = (dx - ((0.5)*(a)*(t*t)))/t;
	            	Vf = (dx + ((0.5)*(a)*(t*t)))/t;
				}
		        if(x == 3) {
		        	a=(2*((Vf*t) - dx))/(t*t);
		        	Vo = Vf - (a * t);
				}
		        if(x == 4) {
		        	dx = (Vf*t)-((0.5)*(a)*(t * t));
		        	Vo = Vf - (a * t);
				}
		        if(x == 5) {
		        	if((dx < 0)&&(a<0)) {
		        		u = -1;
		        	}
		        
		        		ada = ((Vf * Vf)-((4)*(0.5*a)*(dx)));
		        	
		        	if(ada < 0) {
		        		u = -1;
		        		ada = ada * -1;
		        	}
		        	Vo = java.lang.Math.sqrt(ada);
		        	 if(u < 0) {
		        		 Vo = Vo * u;
			        	}
		        	 if((Vo > 0)&&(Vo < 0.00001)) {
		             	Vo = 0;
		             }
		             else if ((Vo < 0)&&(Vo > -0.00001)) {
		             	Vo = 0;
		             }
	         	t = (Vf - Vo) / a;
	         	u = 1;
	         	ada =0;
		        }
				
			}
	        if(m == 3) {
	            if(x == 1) {
	            	a=(-2*((Vo*t) - dx))/(t*t);
	            	Vf = Vo + (a * t);
				}
		        if(x == 2) {
		        	a=(2*((Vf*t) - dx))/(t*t);
		        	Vo = Vf - (a * t);
				}
		        if(x == 4) {
		        	a = (Vf - Vo)/ t;
		        	dx = (t/2)*(Vf + Vo);
				}
		        if(x == 5) {
		        	t =(2*dx)/(Vf+Vo);
		        	t = (Vf - Vo)/a;
		        	t = java.lang.Math.abs(t);
		        	a=(2*((Vf*t) - dx))/(t*t);
				}
				
			}
	        if(m == 4) {
	            if(x == 1) {
	            	dx = (Vo*t)+((0.5)*(a)*(t * t));	
		        	Vf = Vo + (a * t);
				}
		        if(x == 2) {
		        	Vo = Vf - (a * t);
		        	dx = (Vf*t) - ((0.5)*(a)*(t * t));
				}
		        if(x == 3) {
		        	dx = (t/2)*(Vf + Vo);
		        	a = (Vf - Vo)/ t;
		        	
				}
		        if(x == 5) {
		        	t = (Vf - Vo)/(a);
	                t = java.lang.Math.abs(t);
		        	dx = (t/2)*(Vf + Vo);
				}
				
			}
	        if(m == 5) {
	            if(x == 1) {
	            	if((dx < 0)&&(a<0)) {
		        		u = -1;
		        	}
		        	
		        		ada = ((Vo * Vo)+((4)*(0.5*a)*(dx)));
		   
		        	if(ada < 0) {
		        		u = -1;
		        		ada = ada * -1;
		        	}
		        	Vf = java.lang.Math.sqrt(ada);
		        	 if((Vf > 0)&&(Vf < 0.00001)) {
			             	Vf = 0;
			             }
			             else if ((Vf < 0)&&(Vf > -0.00001)) {
			             	Vf = 0;
			             }
		        	 if(u < 0) {
		        		 Vf = Vf * u;
			        	}
	            	t = (Vf - Vo) / a;
	            	u = 1;
	            	ada = 0;
	            }
		        if(x == 2) {
		        	if((dx < 0)&&(a>0)) {
		        		u = -1;
		        	}
	        	Vo = java.lang.Math.sqrt(((Vf * Vf)-((4)*(0.5*a)*(dx))));
	        	 if((dx < 0)&&(a>0)) {
	        		 Vo = Vo * u;
		        	}
	        	 if((Vo > 0)&&(Vo < 0.00001)) {
		             	Vo = 0;
		             }
		             else if ((Vo < 0)&&(Vo > -0.00001)) {
		             	Vo = 0;
		             }
	     	    t = (Vf - Vo) / a;
	     	    u = 1;
				}
		        if(x == 3) {
		        	
		         t =(2*dx)/(Vf+Vo);
		         t = java.lang.Math.abs(t);
		         a=(2*((Vf*t) - dx))/(t*t);
				}
		        if(x == 4) {
		        	
		        t = (Vf - Vo)/ a;
		        t = java.lang.Math.abs(t);
		        dx = (t/2)*(Vf + Vo);
				}
				
			}
	        if(r == 0 ) {
	        	System.out.println("     m ="+m+" x= "+x);	
	        }
	        if((Vo > 0)&&(Vo < 0.00001)) {
	        	Vo = 0;
	        }
	        else if ((Vo < 0)&&(Vo > -0.00001)) {
	        	Vo = 0;
	        }
	        
			System.out.println("Vf :: "+ Vf);
			System.out.println("Vo :: "+ Vo);
			System.out.println("a :: "+ a);
			System.out.println("dx :: "+ dx);
			System.out.println("t :: "+ t);
			//exe 105 0 3.2 1720 32.8
			//ese 46.1 18.5 11.2 79.7 2.47
			//exe 0 155 -10 1201.25 15.5
			if(r != 0) {
			System.out.print("do you want to do a full cheak 0 - no or 1 - yes:: ");
			y = in.nextInt();
			}
			if((y == 1)&&(r != 0)) {
				m = 1;
				x = 1;
				r = 0;
			}
			else if(y == 1) {
				x++;
				if((x > 5)&&(m != 5)) {
				m++;
				x = 1;
				}
				
			}
			if( m >= 5) {
				if(x >= 5) {
					System.out.println("do you want to go again true or false");
					we = in.nextBoolean();
					y = 0;
				}
			}
			}
		 }
		}

}

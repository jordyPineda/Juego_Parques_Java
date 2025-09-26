/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prototype;

import State.*;



public abstract class Ficha_abstracta {
    
    int pos;
    int jug;
    int recorrido;
    String color;
    Estado_ficha estado;
    
    public Ficha_abstracta(int jug,Estado_ficha estado){
    
    this.jug=jug;
    switch(this.jug){
         case 1:
             this.pos=70;
             this.color="Azul";
             break;
         case 2:
             this.pos=71;
             this.color="Rojo";
             break;
         case 3:
             this.pos=72;
             this.color="Verde";
             break;             
         case 4:
             this.pos=73;
             this.color="Amarillo";
             break;
         default:
    }
    this.estado=estado;
    recorrido =0;
    
    
    }
    
    public int getEstado(){
    return estado.getEstado();
    
    }
    
    public int getPos(){
    return pos;
    
    }
    
    public void setEstado(Estado_ficha n){
        
        this.estado=n;
    }
    
    public void setPos(int a){
     this.pos = a;
    
    }
    
    public void actPos(int a){
        
        int b = this.pos + a;
        recorrido = recorrido + a;
        if (b>=68)b=b-68;
        this.pos = b;
        if (b==0 || b==5 || b ==12 || b==17 || b==22 || b==29 || b==34 || b==39 || b==46 || b==51 || b==56 || b==63){
        this.estado = new Seguro();
        }else this.estado = new Inseguro();
        
        if (recorrido>= 63){
            recorrido = recorrido-63;
            this.estado = new Final();
            Final(recorrido);
        }
    }
    
    public void actPosF(int a){
        
        switch (jug){
        case 1:
            if((pos+a)>81){
                
                if(81+(81-(pos+a))<74){
                this.pos = 74;
                }else{
                this.pos = 81+ (81-(pos+a));
                }
              
            
            }else if((pos+a)==81){
                
                this.estado = new Fuera();
                this.pos = 106;
                System.out.println("Felicidades, una ficha se ha coronado");
            
            }else this.pos = pos+a;          
        break;
        case 2:
            if((pos+a)>89){
              
                if(89+(89-(pos+a))<82){
                this.pos = 82;
                }else{
                this.pos = 89+ (89-(pos+a));
                }
            
            }else if((pos+a)==89){
                this.pos = 107;
                this.estado = new Fuera();
                System.out.println("Felicidades, una ficha se ha coronado");
            
            }else this.pos = pos+a;    
        break;
        case 3:
            if((pos+a)>97){
              
                if(97+(97-(pos+a))<90){
                this.pos = 90;
                }else{
                this.pos = 97+ (97-(pos+a));
                }
            
            }else if((pos+a)==97){
                this.pos = 108;
                this.estado = new Fuera();
                System.out.println("Felicidades, una ficha se ha coronado");
            
            }else this.pos = pos+a;
         break;   
        case 4:
            if((pos+a)>105){
              
                if(105+(105-(pos+a))< 98){
                this.pos = 98;
                }else{
                this.pos = 105+ (105-(pos+a));
                }
            
            }else if((pos+a)==105){
                this.pos = 109;
                this.estado = new Fuera();
                System.out.println("Felicidades, una ficha se ha coronado");
            
            }else this.pos = pos+a;
        break;
        }
    }
    
    public void Final(int a){
        
        switch (jug){
        case 1:
            if (74+a==81){
                this.estado = new Fuera();
                this.pos = 106;
                System.out.println("Felicidades, una ficha se ha coronado");
            }else if(74+a>81){
              this.pos = 81-(74+a-81);
            }else this.pos = 74+a;            
        break;
        case 2:
            if (82+a==89){
                this.estado = new Fuera();
                this.pos = 107;
                System.out.println("Felicidades, una ficha se ha coronado");
            }else if(82+a>89){
              this.pos = 89-(82+a-89);
            }else this.pos = 82+a;  
        break;
        case 3:
            if (90+a==97){
                this.estado = new Fuera();
                this.pos = 108;
                System.out.println("Felicidades, una ficha se ha coronado");
            }else if(90+a>97){
              this.pos = 97-(90+a-97);
            }else this.pos = 90+a;  
         break;   
        case 4:
            if (98+a==105){
                this.estado = new Fuera();
                this.pos = 109;
                System.out.println("Felicidades, una ficha se ha coronado");
            }else if(98+a>105){
              this.pos = 105-(98+a-105);
            }else this.pos = 98+a;  
         break;
        }
    
    
    }
    
    public abstract Ficha_abstracta clonar();
    
      
    
    
}

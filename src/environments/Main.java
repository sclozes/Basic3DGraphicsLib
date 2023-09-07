package environments;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Main {
    public static void main(String[] args) {

        Window w = new Window( Color.BLACK,"Test");

        w.showPoints(false);
        w.setPerspective(true);
        w.addBasicMovements();

        //Component m = new Cuboid(w,new Location(0,0,0),100,100,100,Color.RED);

        double[][] arr = new double[100][100];

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                //arr[i][j] = (Math.sin((i-50)/2.0) + Math.sin((j-50)/2.0))*3;
                arr[i][j] = w.generateNoise(i/2.0,j/2.0,0.1)*30;
            }
        }

        //Component m = new ObjModel(w,"src//Utah_teapot_(solid).obj",new Location(0,0,0), 100,300,500,false,Color.white);

        Component m = new Mesh(w,new Location(0,0,0),500,arr,500,Color.WHITE);


//        Component m = new NewShape(w,new Location(0,0,0));
//
//
//
//        java.util.List<java.util.List<Point>> parr = new java.util.ArrayList<>();
//
//        for(int i = -50; i < 50; i++) {
//            java.util.List<Point> temp = new java.util.ArrayList<>();
//            for(int j = -50; j < 50; j++) {
//                //java.util.List<Point> temp = new java.util.ArrayList<>();
//                //parr[i + 50][j + 50] = new Point(w,new Location((i )*5,w.generateNoise(i,j,0.1) * 30,(j)*5),Color.BLUE);
//                temp.add(new Point(w,new Location((i )*5,w.generateNoise(i,j,0.1) * 30,(j)*5),Color.BLUE));
//                //parr.get(i + 50).add(new Point(w,new Location((i )*5,w.generateNoise(i,j,0.1) * 30,(j)*5),Color.BLUE));
//                //w.waitInSeconds(0.001);
//
//            }
//            parr.add(temp);
//        }
//        //System.out.println("1");
//        double avg = 0;
//        double min = -2;
//        for(int i = 0; i < 100; i++) {
//            for(int j = 0; j < 100; j++) {
//                m.addPoint(parr.get(i).get(j));
//
//                if(i < 99 && j < 99) {
//                    avg = (parr.get(i).get(j).getY() + parr.get(i).get(j + 1).getY() + parr.get(i + 1).get(j).getY())/3.0;
//                    if(avg <= min) {
//                        Point[] temp = {parr.get(i).get(j),parr.get(i + 1).get(j),parr.get(i + 1).get(j + 1)};
//                        parr.get(i).get(j).setY(min);
//                        parr.get(i + 1).get(j).setY(min);
//                        parr.get(i + 1).get(j + 1).setY(min);
//                        m.addPolygon(new Face(m,temp,Color.BLUE));
//                    }
//                    else {
//                        Point[] temp = {parr.get(i).get(j),parr.get(i + 1).get(j),parr.get(i + 1).get(j + 1)};
//                        m.addPolygon(new Face(m,temp,new Color(200,200,100)));
//                    }
//
//                    //avg = (parr[i + 1][j + 1].getY() + parr[i][j + 1].getY() + parr[i + 1][j].getY())/3.0;
//                    if(avg <= min) {
//                        Point[] temp = {parr.get(i).get(j),parr.get(i + 1).get(j + 1),parr.get(i).get(j + 1)};
//                        parr.get(i).get(j).setY(min);
//                        parr.get(i + 1).get(j + 1).setY(min);
//                        parr.get(i).get(j + 1).setY(min);
//                        m.addPolygon(new Face(m,temp,Color.BLUE));
//                    }
//                    else {
//                        Point[] temp = {parr.get(i).get(j),parr.get(i + 1).get(j + 1),parr.get(i).get(j + 1)};
//                        m.addPolygon(new Face(m,temp,new Color(200,200,100)));
//                    }
//                }
//
//                //w.waitInSeconds(0.001);
//            }
//        }
        //System.out.println("done");



//        double[][][] arr = new double[6][100][100];
//
//        for(int i = 0; i < 6; i++) {
//
//            for(int j = 0; j < arr[0].length; j++) {
//
//                for(int o = 0; o < arr[0][0].length; o++) {
//                    //arr[i][j][o] = (o - 50) * (o - 50)/-20.1 + (j - 50) * (j - 50)/20.1 - 50;
//                    arr[i][j][o] = w.generateNoise(o,j,0.1) * 30;
//                    //arr[i][j][o] = Math.sin((double)o/3) * 5 + Math.sin((double)j/3) * 5;
//                    //arr[i][j][o] = 0;
//                }
//            }
//        }
//        String path = "src//ImageToStl.com_suzanne_blender_monkey.obj";
//        //System.out.println(path);
//        String path2 = "src//Utah_teapot_(solid).obj";
//        String path3 = "src//12221_Cat_v1_l3.obj";
//        String path4 = "src//FinalBaseMesh.obj";
//        String path5 = "src//16433_Pig.obj";
//        String path6 = "src//ImageToStl.com_30 ביולי 2023.obj";
//        String path7 = "src//FabConvert.com_31 ביולי 2023.obj";
//        String path8 = "src//FabConvert.com_mario64.obj";
//        String path9 = "src//11803_Airplane_v1_l1.obj";
//        String path10 = "src//17257_Booster_rocket_for_space_shuttle_v1_NEW.obj";
//        String path11 = "src//Saturn V.obj";
//        String path12 = "src//Bob-omb Battlefield.obj";
//
//
//        //Component m = new Sphere(w,new Location(0,0,-170),100,arr,Color.BLUE);
//
//        Component m = new ObjModel(w,path,new Location(0,0,0), 100,300,100,false,Color.white);
        //m.setRotationX(-90);


//        Component m2 = new ObjModel(w,path,new Location(50,30,0), 100,100,100,false,Color.GREEN);
//        Component m = new Sphere(w,new Location(0,0,0),50,arr,Color.WHITE);
//        Component m1 = new ObjModel(w,path,new Location(-50,30,0), 100,100,100,false,Color.BLUE);

        //Component m3 = new Mesh(w,new Location(0,0,-130),700,arr[0],700,Color.WHITE);
        //Component m = new Group(w,m2,m3);
//
//        Component m4 = new Group(w,m1,m2);
//        Component m = new Group(w,m3,m4);
//
//        m.setRotationX(5);

        //Component m = new Cuboid(w,new Location(0,0,0),100,100,100,Color.BLUE);
        //m.setRotationZ(90);

        //Component m = new Mesh(w,new Location(0,0,0),400,arr[0],400,Color.WHITE);

        //Component p = new Pyramid(w,new Location(0,0,0),100,100,100,Color.red);

        //w.addBasicMovements();

        w.setKeyAction(KeyEvent.VK_E, () -> {
            m.setRotationY(m.getRotation().yRotation - 5);
            //System.out.println(m.getRotation().yRotation);
        });

        w.setKeyAction(KeyEvent.VK_Q, () -> {
            m.setRotationY(m.getRotation().yRotation + 5);
            //System.out.println(m.getRotation().yRotation);
        });
        w.setKeyAction(KeyEvent.VK_R, () -> {
            m.setRotationX(m.getRotation().xRotation - 5);
            //System.out.println(m.getRotation().xRotation);
        });

        w.setKeyAction(KeyEvent.VK_F, () -> {
            m.setRotationX(m.getRotation().xRotation + 5);
            //System.out.println(m.getRotation().xRotation);
        });
        w.setKeyAction(KeyEvent.VK_ENTER, () -> {
            w.setPerspective(!w.getPerspective());
        });
        w.setKeyAction(KeyEvent.VK_LEFT, () -> {
            w.setCameraYRotation(w.cameraYRotation + 5);
            //System.out.println(w.cameraYRotation);
        });
        w.setKeyAction(KeyEvent.VK_RIGHT, () -> {
            w.setCameraYRotation(w.cameraYRotation - 5);
            //System.out.println(w.cameraYRotation);
        });
        w.setKeyAction(KeyEvent.VK_UP, () -> {
            w.setCameraXRotation(w.cameraXRotation - 5);
            //System.out.println(w.cameraYRotation);
        });
        w.setKeyAction(KeyEvent.VK_DOWN, () -> {
            w.setCameraXRotation(w.cameraXRotation + 5);
            //System.out.println(w.cameraYRotation);
        });




    }
}
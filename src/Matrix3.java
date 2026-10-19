package src;

public class Matrix3 {
    double[] values;
    Matrix3 (double[] values){
        this.values = values;
    }
    Matrix3 multiply(Matrix3 other){
        double[] result = new double[9];
        for(int row=0;row<3;row++){
            for (int column=0;column<3;column++){
                for (int i=0;i<3;i++){
                    result[row * 3 + column] += this.values[row * 3 + i] * other.values[i*3+column];
                }
            }
        }
        return new Matrix3(result);
    }

    Vertex transform(Vertex in){
        return new Vertex(
                in.x * values[0] + in.y * values[3] + in.z * values[6],
                in.x * values[1] + in.y * values[4] + in.z * values[7],
                in.x * values[2] + in.y * values[5] + in.z * values[8]
        );
    }

}

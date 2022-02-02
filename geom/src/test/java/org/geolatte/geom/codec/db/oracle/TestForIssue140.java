package org.geolatte.geom.codec.db.oracle;

import org.geolatte.geom.Geometry;
import org.geolatte.geom.codec.Wkt;
import org.geolatte.geom.codec.db.Decoder;
import org.geolatte.geom.codec.db.Encoder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestForIssue140 {


    @Test
    //this is the test as provided in PR #141
    public void test_sdo(){
        SDOGeometry sdo = SDOGeometryHelper.sdoGeometry(2004, 4326, null, new int[]{ 1, 1, 1, 3, 1, 3, 9, 1003, 1, 19, 2003, 1} ,
                new Double[]{10.,5.,10.,10.,20.,10.,20.,10.,0.,0.,50.,0.,100.,100.,0.,100.,0.,0.,1.,1.,49.,1.,99.,99.,1.,99.,1.,1.});
        Decoder<SDOGeometry> decoder = Decoders.decoderFor(sdo);
        Geometry<?> decoded = decoder.decode(sdo);
        //TODO -- finish this  by decoding the sdo properly
    }

    @Test
    public void should_parse(){
        Geometry<?>  parsedWkt = Wkt.fromWkt(WKT_1);
        Encoder<SDOGeometry> sdoEncoder = Encoders.encoderFor(parsedWkt);
        SDOGeometry sdoGeom = sdoEncoder.encode(parsedWkt);
        Decoder<SDOGeometry> decoder = Decoders.decoderFor(sdoGeom);
        Geometry<?> decoded = decoder.decode(sdoGeom);
        assertEquals(parsedWkt, decoded);
    }


    static String WKT_1 = "GEOMETRYCOLLECTION (LINESTRING (210949.01 638433.59, 210957.0 638454.21), MULTIPOINT ((210921.03 638080.97), (210919.92 638274.15), (210924.77 638056.98), (210929.6 638283.58), (210926.94 638271.23), (210930.11 637940.3), (210963.71 638468.55), (210955.13 637928.58), (210983.74 638504.63))))";
    static String WKT_2 = "GEOMETRYCOLLECTION (LINESTRING (210949.01 638433.59, 210957.0 638454.21), LINESTRING (210945.64 638407.43, 210945.64 638407.44, 210947.6 638421.03, 210947.6 638421.04), LINESTRING (210932.36 638722.29, 210932.37 638722.29), LINESTRING (210921.9 638188.45, 210924.12 638190.58), MULTIPOINT ((210921.03 638080.97), (210919.92 638274.15), (210924.77 638056.98), (210929.6 638283.58), (210926.94 638271.23), (210930.11 637940.3), (210963.71 638468.55), (210955.13 637928.58), (210983.74 638504.63)), POLYGON ((211015.1 638577.87, 211013.45 638567.87, 211015.11 638577.88, 211015.1 638577.87)), POLYGON ((210996.51 638532.76, 211002.12 638533.0, 211002.123782194 638533.009723407, 210996.51 638532.76)), POLYGON ((210944.92 638429.26, 210949.0 638433.57, 210949.01 638433.59, 210944.92 638429.26)), POLYGON ((210942.64 637949.64, 210942.628783383 637949.63, 210942.64 637949.63, 210946.21 637952.83, 210946.209233244 637952.84137355, 210942.64 637949.64)), POLYGON ((210943.86 638387.06, 210942.541867683 638381.725000005, 210943.87 638387.05, 210945.64 638407.43, 210943.86 638387.06)), POLYGON ((210930.16 638304.53, 210929.877514327 638293.775, 210930.17 638304.52, 210935.07 638349.32, 210937.348586786 638354.020706598, 210935.06 638349.33, 210930.16 638304.53)), POLYGON ((210928.789310344 638001.199999998, 210929.13 638002.34, 210930.06 638003.99, 210929.13 638002.37, 210928.789310344 638001.199999998)), POLYGON ((210919.09 638012.53, 210921.82 638013.6, 210924.17 638017.48, 210928.53 638019.09, 210928.53 638019.11, 210924.18 638017.51, 210921.83 638013.64, 210919.09 638012.55, 210919.09 638012.53)), POLYGON ((210919.655908553 638009.779882999, 210919.09 638012.53, 210919.65 638009.78, 210919.655908553 638009.779882999)), POLYGON ((210920.659442823 638090.657599327, 210917.02 638089.83, 210917.018993718 638089.824307319, 210920.66 638090.65, 210920.659442823 638090.657599327)), POLYGON ((210914.7 638133.41, 210914.700075884 638133.404536378, 210916.76 638133.87, 210916.77 638133.88, 210914.7 638133.41)), POLYGON ((210874.328514051 637438.627868085, 210880.58 637436.66, 210888.36 637438.49, 210890.58 637449.85, 210906.61 637448.88, 211087.4 637405.78, 211158.93 637362.37, 211328.59 637334.07, 211301.49 637759.84, 211095.17 637803.82, 211093.0 637810.37, 211086.36 637810.48, 211078.75 637809.42, 211072.74 637815.45, 211072.81 637819.26, 211066.67 637821.9, 211055.85 637828.65, 211050.89 637833.94, 211052.18 637839.01, 211049.41 637840.99, 211045.72 637841.41, 211042.35 637841.98, 211042.33 637847.52, 211033.2 637858.53, 211037.64 637870.03, 211050.7 637879.49, 211055.32 637888.27, 211056.15 637892.62, 211058.39 637896.18, 211061.69 637897.71, 211063.75 637898.86, 211041.24 637905.58, 211027.25 637902.11, 211022.73 637901.74, 211018.734940562 637902.50234226, 211020.55 637901.81, 211028.66 637898.73, 211023.86 637887.92, 210874.328514051 637438.627868085)))";
}

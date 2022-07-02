package com.epam.rd.autotasks;

import java.math.BigInteger;

public class Battleship8x8 {
    private final long ships;
    private long shots = 0L;

    public Battleship8x8(final long ships) {
        this.ships = ships;
    }

    public boolean shoot(String shot) {
        String longShips = String.format("%64s", Long.toBinaryString(ships)).replace(' ', '0');
        String longShots = String.format("%64s", Long.toBinaryString(shots)).replace(' ', '0');

        int shotNumber = Integer.parseInt(shot.substring(1, 2));
        int i = 0;

        switch (shot.charAt(0)){
            case 'A':
                i = 0;
                break;
            case 'B':
                i = 1;
                break;
            case 'C':
                i = 2;
                break;
            case 'D':
                i = 3;
                break;
            case 'E':
                i = 4;
                break;
            case 'F':
                i = 5;
                break;
            case 'G':
                i = 6;
                break;
            case 'H':
                i = 7;
                break;
        }

        int position = 8 * (shotNumber - 1) + i;

        StringBuilder str = new StringBuilder(longShots);
        str.setCharAt(position, '1');
        shots = new BigInteger(str.toString(), 2).longValue();

        return longShips.charAt(position) == '1';
    }

    public String state() {
        String longShips = String.format("%64s", Long.toBinaryString(ships)).replace(' ', '0').replace('1', '\u2610').replace('0', '.');
        String longShots = String.format("%64s", Long.toBinaryString(shots)).replace(' ', '0');

        for (int i = 0; i < 64; i++){
            if (longShots.charAt(i) == '1'){
                if (longShips.charAt(i) == '.'){
                    StringBuilder str = new StringBuilder(longShips);
                    str.setCharAt(i, '\u00D7');
                    longShips = str.toString();
                }
                else {
                    StringBuilder str = new StringBuilder(longShips);
                    str.setCharAt(i, '\u2612');
                    longShips = str.toString();
                }
            }
        }

        String string1 = longShips.substring(0,8);
        String string2 = longShips.substring(8,16);
        String string3 = longShips.substring(16,24);
        String string4 = longShips.substring(24,32);
        String string5 = longShips.substring(32,40);
        String string6 = longShips.substring(40,48);
        String string7 = longShips.substring(48,56);
        String string8 = longShips.substring(56);

        return string1 + "\n" + string2 + "\n" + string3 + "\n" + string4 + "\n" + string5 + "\n" + string6 + "\n" + string7 + "\n" + string8;
    }
}

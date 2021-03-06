/*
Copyright (c) 2009, University of Nevada, Las Vegas
All rights reserved.

Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:

    * Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
    * Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
    * Neither the name of the University of Nevada, Las Vegas, nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package com.unlv.edu.jlh.geom;

public class Segment {
	private final Point sourcePoint;
	private final Point targetPoint;

	public Segment(Point sourcePoint, Point targetPoint) {
		this.sourcePoint = sourcePoint;
		this.targetPoint = targetPoint;
	}

	public double getAngleRadians() {
		return sourcePoint.getAngleRadians(targetPoint);
	}

	public double getAngleDegrees() {
		return getAngleRadians() * (180.0 / Math.PI);
	}

	public double getAngleDegreesWithSegment(final Segment otherSegment) {
		return getAngleRadiansWithSegment(otherSegment) * (180.0 / Math.PI);
	}

	public Point getSourcePoint() {
		return sourcePoint;
	}

	public Point getTargetPoint() {
		return targetPoint;
	}

	public double getAngleRadiansWithSegment(final Segment otherSegment) {
		if (otherSegment == null) {
			return 0.0;
		}
		double a1 = getAngleRadians();
		double a2 = otherSegment.getAngleRadians();
		if (a2 >= a1) {
			return a2 - a1;
		}
		else {
			return 2.0 * Math.PI - (a1 - a2);
		}
	}

	@Override
	public boolean equals(Object otherSegment) {
		if (!(otherSegment instanceof Segment) || otherSegment == null) {
			return false;
		}
		Segment segment = (Segment) otherSegment;
		return (this.getSourcePoint().equals(segment.getSourcePoint())
				&& this.getTargetPoint().equals(segment.getTargetPoint()));
	}

}

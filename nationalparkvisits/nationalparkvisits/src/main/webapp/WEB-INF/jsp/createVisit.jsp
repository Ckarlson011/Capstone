<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="include/header.jsp" />

<div class="container">
    <div class="row mt-3 mb-1">
        <h2>Create Visit</h2>
    </div>
    <c:if test="${bindingResult.hasErrors()}">
        <c:forEach items="${bindingResult.getAllErrors()}" var="error">
            <p class="mb-0" style="color:red">${error.getDefaultMessage()}</p>
        </c:forEach>
    </c:if>
    <form action="/createVisit" method="POST">
        <div class="mb-3">
            <label for="park" class="form-label">Choose the park</label>
            <select id="park" name="park">
                <option value="1">ACADIA NATIONAL PARK</option>
                <option value="2">AMERICAN SAMOA</option>
                <option value="3">ARCHES</option>
                <option value="4">BADLANDS</option>
                <option value="5">BIG BEND</option>
                <option value="6">BISCAYNE</option>
                <option value="7">BLACK CANYON OF THE GUNNISON</option>
                <option value="8">BRYCE CANYON</option>
                <option value="9">CANYONLANDS</option>
                <option value="10">CAPITOL REEF</option>
                <option value="11">CARLSBAD CAVERNS</option>
                <option value="12">CHANNEL ISLANDS</option>
                <option value="13">CONGAREE</option>
                <option value="14">CRATER LAKE</option>
                <option value="15">CUYAHOGA VALLEY</option>
                <option value="16">DEATH VALLEY</option>
                <option value="17">DENALI</option>
                <option value="18">DRY TORTUGAS</option>
                <option value="19">EVERGLADES</option>
                <option value="20">GATES OF THE ARCTIC</option>
                <option value="21">GATEWAY ARCH</option>
                <option value="22">GLACIER BAY</option>
                <option value="23">GLACIER</option>
                <option value="24">GRAND CANYON</option>
                <option value="25">GRAND TETON</option>
                <option value="26">GREAT BASIN</option>
                <option value="27">GREAT SAND DUNES</option>
                <option value="28">GREAT SMOKY MOUNTAINS</option>
                <option value="29">GUADALUPE MOUNTAINS</option>
                <option value="30">HALEAKALA</option>
                <option value="31">HAWAI'I VOLCANOES</option>
                <option value="32">HOT SPRINGS</option>
                <option value="33">INDIANA DUNES</option>
                <option value="34">ISLE ROYALE</option>
                <option value="35">JOSHUA TREE</option>
                <option value="36">KATMAI</option>
                <option value="37">KENAI FJORDS</option>
                <option value="38">KINGS CANYON</option>
                <option value="39">KOBUK VALLEY</option>
                <option value="40">LAKE CLARK</option>
                <option value="41">LASSEN VOLCANIC</option>
                <option value="42">MAMMOTH CAVE</option>
                <option value="43">MESA VERDE</option>
                <option value="44">MOUNT RAINIER</option>
                <option value="45">NEW RIVER GORGE</option>
                <option value="46">NORTH CASCADES</option>
                <option value="47">OLYMPIC</option>
                <option value="48">PETRIFIED FOREST</option>
                <option value="49">PINNACLES</option>
                <option value="50">REDWOOD</option>
                <option value="51">ROCKY MOUNTAIN</option>
                <option value="52">SAGUARO</option>
                <option value="53">SEQUOIA</option>
                <option value="54">SHENANDOAH</option>
                <option value="55">THEODORE ROOSEVELT</option>
                <option value="56">VIRGIN ISLANDS</option>
                <option value="57">VOYAGEURS</option>
                <option value="58">WHITE SANDS</option>
                <option value="59">WIND CAVE</option>
                <option value="60">WRANGELL - ST. ELIAS</option>
                <option value="61">YELLOWSTONE</option>
                <option value="62">YOSEMITE</option>
                <option value="63">ZION</option>
            </select>
        </div>
        <div class="mb-3">
            <label for="description" class="form-label">About The Visit</label>
            <textarea rows="5" cols="50" class="form-control" id="description" name="description"></textarea>
        </div>
        <div class="row">
            <div class="mb-3 col-6">
                <label for="start">Start date:</label>
                <input type="date" id="start" name="start">
            </div>
            <div class="mb-3 col-6">
                <label for="end">Start date:</label>
                <input type="date" id="end" name="end">
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

<jsp:include page="include/footer.jsp" />
/*******************************************************************************
 * Copyright (c) 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
/**
  * Object Object()
  * @constructor
  * @class Object
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
function Object(){}
 /**
  * function toString() 
  * @type    String
  * @class   Object
  * @return  String
  * @throws  DOMException
  * @see     Object
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */  
Object.prototype.toString = function( ){return "";};
 /**
  * function toLocaleString() 
  * @type    String
  * @class   Object
  * @return  String
  * @throws  DOMException
  * @see     Object
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */  
Object.prototype.toLocaleString  = function( ){return "";};
 /**
  * function valueOf() 
  * @type    Object
  * @class   Object
  * @return  Object
  * @throws  DOMException
  * @see     Object
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */  
Object.prototype.valueOf = function( ){;};
 /**
  * function hasOwnProperty(V) 
  * @type    Boolean
  * @class   Object
  * @param   V Object
  * @return  Boolean
  * @throws  DOMException
  * @see     Object
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */  
Object.prototype.hasOwnProperty  = function (V){return true;};
 /**
  * function isPrototypeOf(V) 
  * @type    Boolean
  * @class   Object
  * @param   V Object
  * @return  Boolean
  * @throws  DOMException
  * @see     Object
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */  
Object.prototype.isPrototypeOf  = function (V){return true;};
 /**
  * function propertyIsEnumerable(V) 
  * @type    String
  * @class   Object
  * @param   V Object
  * @return  String
  * @throws  DOMException
  * @see     Object
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */  
Object.prototype.propertyIsEnumerable  = function(V){return "";};
/**
  * Property constructor
  * @type  String
  * @class Object
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */ 
Object.prototype.constructor="";

/**
  * Property Class
  * @type  String
  * @class Object
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */ 
Object.prototype.Class="";
/**
  * Property Value
  * @class Object
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */ 
Object.prototype.Value=0;
/**
  * function Get(property)
  * @class Object
  * @type Object
  * @return Object
  * @param property String
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */ 
Object.prototype.Get=function(property){};
/**
  * function Put(property, value)
  * @class Object
  * @param property String
  * @param value String
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */ 
Object.prototype.Put=function(property, value){};
/**
  * function CanPut(property)
  * @class Object
  * @param property String
  * @type Boolean
  * @return Boolean
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */ 
Object.prototype.CanPut=function(property){};
/**
  * function HasProperty(property)
  * @class Object
  * @param property String
  * @type Boolean
  * @return Boolean
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */ 
Object.prototype.HasProperty=function(property){};
/**
  * function Delete(property)
  * @class Object
  * @param property String
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */ 
Object.prototype.Delete=function(property){};
/**
  * function DefaultValue()
  * @class Object
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */ 
Object.prototype.DefaultValue=function(){};
/**
  * function Match(value,index)
  * @class Object
  * @param value String
  * @param index String
  * @type Object
  * @return Object
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */ 
Object.prototype.Match=function(value,index){};
/**
  * Object String()
  * @super Object
  * @type  constructor
  * @class String
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */

function String(){}
String.prototype = new Object();

/**
  * static function fromCharCode(chars)
  * @type    String
  * @return String
  * @param chars Array
  * @class   String
  * @see     String
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */  
String.fromCharCode=function(chars){};
/**
  * Property length
  * @type    Number
  * @class   String
  * @see     String
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */  
String.prototype.length =1;
 /**
  * function charAt(pos) 
  * @type    String
  * @class   String
  * @param   pos Number
  * @return  String
  * @throws  DOMException
  * @see     String
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */  
String.prototype.charAt = function(pos){return "";};
 /**
  * function charCodeAt(pos) 
  * @type    String
  * @class   String
  * @param   pos Number
  * @return  String
  * @throws  DOMException
  * @see     String
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */  
String.prototype.charCodeAt= function(pos){return "";};
 /**
  * function concat() 
  * @type    String
  * @class   String
  * @return  String
  * @throws  DOMException
  * @see     String
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */  
String.prototype.concat= function(){return "";};
 /**
  * function indexOf(searchString, position) 
  * @type    Number
  * @class   String
  * @param   searchString String
  * @param   position Number
  * @return  Number
  * @throws  DOMException
  * @see     String
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */  
String.prototype.indexOf = function(searchString, position){return 1;};
 /**
  * function lastIndexOf(pos) 
  * @type    Number
  * @class   String
  * @param   searchString String
  * @param   position Number
  * @return  Number
  * @throws  DOMException
  * @see     String
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */  
String.prototype.lastIndexOf = function(searchString, position){return 1;};
 /**
  * function localeCompare(that) 
  * @type    Boolean
  * @class   String
  * @param   that String
  * @return  Boolean
  * @throws  DOMException
  * @see     String
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */  
String.prototype.localeCompare = function(that){return true;};
 /**
  * function match(regexp) 
  * @type    Boolean
  * @class   String
  * @param   regexp String
  * @return  Boolean
  * @throws  DOMException
  * @see     String
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */  
String.prototype.match = function(regexp){return true;};
 /**
  * function replace(searchValue, replaceValue) 
  * @type    String
  * @class   String
  * @param   searchValue String
  * @param   replaceValue String
  * @return  String
  * @throws  DOMException
  * @see     String
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */  
String.prototype.replace = function(searchValue, replaceValue){return "";};
 /**
  * function search(regexp) 
  * @type    Number
  * @class   String
  * @param   regexp String
  * @return  Number
  * @throws  DOMException
  * @see     String
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */  
String.prototype.search = function(regexp){return 1;};
 /**
  * function slice(start, end) 
  * @type    String
  * @class   String
  * @param   start String
  * @param   end String
  * @return  String
  * @throws  DOMException
  * @see     String
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */  
String.prototype.slice = function(start, end){return "";};
 /**
  * function split(separator, limit) 
  * @type    String
  * @class   String
  * @param   separator String
  * @param   limit String
  * @return  String
  * @throws  DOMException
  * @see     String
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */  
String.prototype.split = function(separator, limit){return "";};
 /**
  * function substring(start, end) 
  * @type    String
  * @class   String
  * @param   start String
  * @param   end String
  * @return  String
  * @throws  DOMException
  * @see     String
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */  
String.prototype.substring = function(start, end){return "";};
 /**
  * function toLowerCase() 
  * @type    String
  * @class   String
  * @return  String
  * @throws  DOMException
  * @see     String
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */  
String.prototype.toLowerCase = function( ){return "";};
 /**
  * function toLocaleLowerCase() 
  * @type    String
  * @class   String
  * @return  String
  * @throws  DOMException
  * @see     String
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */  
String.prototype.toLocaleLowerCase = function( ){return "";};
 /**
  * function toUpperCase() 
  * @type    String
  * @class   String
  * @return  String
  * @throws  DOMException
  * @see     String
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */  
String.prototype.toUpperCase= function ( ){return "";};
 /**
  * function toLocaleUpperCase() 
  * @type    String
  * @class   String
  * @return  String
  * @throws  DOMException
  * @see     String
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */  
String.prototype.toLocaleUpperCase = function( ){return "";};

/**
  * Object Number()
  * @super Object
  * @constructor
  * @class Number
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Number.prototype = new Object();
function Number(){}
/**
  * property MIN_VALUE
  * @type Number
  * @class Number
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Number.MIN_VALUE=0;
/**
  * property MAX_VALUE
  * @type Number
  * @class Number
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Number.MAX_VALUE=0;
/**
  * property NaN
  * @type Number
  * @class Number
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Number.NaN=0;
/**
  * property NEGATIVE_INFINITY
  * @type Number
  * @class Number
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Number.NEGATIVE_INFINITY=0;
/**
  * property POSITIVE_INFINITY
  * @type Number
  * @class Number
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Number.POSITIVE_INFINITY=0;
/**
  * function toFixed(fractionDigits)
  * @type Number
  * @class Number
  * @param fractionDigits Number
  * @type Number
  * @return Number
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Number.prototype.toFixed=function(fractionDigits){};
/**
  * function toExponential(fractionDigits)
  * @type Number
  * @class Number
  * @param fractionDigits Number
  * @type Number
  * @return Number
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Number.prototype.toExponential=function(fractionDigits){};
/**
  * function toPrecision(precision)
  * @type Number
  * @class Number
  * @param precision Number
  * @type Number
  * @return Number
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Number.prototype.toPrecision=function(fractionDigits){};
/**
  * Object Boolean()
  * @super Object
  * @constructor
  * @class Boolean
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
function Boolean(){};
Boolean.prototype = new Object();
/**
  * Object Array()
  * @super Object
  * @constructor
  * @class Array
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Array.prototype = new Object();
function Array(){}
/**
  * Property length
  * @type    Number
  * @class   Array
  * @see     Array
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */  
Array.prototype.length = 1;
/**
  * function concat(args)
  * @param args Array
  * @type    Array
  * @return Array
  * @class   Array
  * @see     Array
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */  
Array.prototype.concat = function(args){};
/**
  * function join(seperator)
  * @param seperator String
  * @type    Array
  * @return Array
  * @class   Array
  * @see     Array
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */  
Array.prototype.join = function(seperator){};
/**
  * function pop()
  * @type    Object
  * @return  Object
  * @class   Array
  * @see     Array
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */  
Array.prototype.pop = function(){};
/**
  * function push(args)
  * @param args Array
  * @class   Array
  * @see     Array
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */  
Array.prototype.push = function(args){};
/**
  * function reverse()
  * @type    Array
  * @return Array
  * @class   Array
  * @see     Array
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */  
Array.prototype.reverse = function(){};
/**
  * function shift()
  * @type    Object
  * @return  Object
  * @class   Array
  * @see     Array
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */  
Array.prototype.shift = function(){};
/**
  * function slice(start, end)
  * @type    Array
  * @return  Array
  * @param start Number
  * @param end Number
  * @class   Array
  * @see     Array
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */  
Array.prototype.slice = function(start, end){};
/**
  * function sort(funct)
  * @type    Array
  * @return  Array
  * @param funct Function
  * @class   Array
  * @see     Array
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */  
Array.prototype.sort = function(funct){};
/**
  * function splice(start, deletecount, items)
  * @type    Array
  * @return  Array
  * @param start Number
  * @param deletecount Number
  * @param items Array
  * @class   Array
  * @see     Array
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */  
Array.prototype.splice = function(start, deletecount, items){};
/**
  * function unshift(items)
  * @type    Array
  * @return  Array
  * @param items Array
  * @class   Array
  * @see     Array
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */  
Array.prototype.unshift = function(start){};
/**
  * Object Function()
  * @super Object
  * @constructor
  * @class Function
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
 
Function.prototype = new Object();
function Function(){};
/**
  * function apply (thisArg, argArray)
  * @param thisArg Object
  * @param argArray Array
  * @type Object
  * @return Object
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */ 
Function.prototype.apply=function(thisArg, argArray){};
/**
  * function call (thisArg, argArray)

  * @param thisArg Object
  * @param argArray Array
  * @type Object
  * @return Object
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */ 
Function.prototype.call=function(thisArg, argArray){};
/**
  * property length
  * @type    Number
  * @return Number
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */ 
Function.prototype.length=0;
/**
  * function HasInstance()
  * @type    Boolean
  * @return Boolean
  * @class   Function
  * @see     Array
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */ 
Function.prototype.HasInstance=function(){};

/**
  * Object Date(s)
  * @super Object
  * @constructor
  * @class Date
  * @param s String
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Date.prototype = new Object();
function Date(s){}
/**
  * function MakeTime(hour, min, sec, ms)
  * @class Date
  * @param hour Number
  * @param min Number
  * @param sec Number
  * @param ms Number  
  * @type Number
  * @return Number
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Date.MakeTime =function(hour, min, sec, ms){};
/**
  * function MakeDay(year, month, date)
  * @class Date
  * @param year Number
  * @param month Number
  * @param date Number
  * @type Number
  * @return Number
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Date.MakeDay =function(year, month, date){};
/**
  * function MakeDate(day,time)
  * @class Date
  * @param day Number
  * @param time Number

  * @type Number
  * @return Number
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Date.MakeDate =function(day,time){};
/**
  * function TimeClip(time)
  * @class Date
  * @param time Number
  * @type Number
  * @return Number
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Date.TimeClip =function(time){};

/**
  * function parse(string)
  * @class Date
  * @param string Strig
  * @type Date
  * @return Date
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Date.parse=function(string){};
/**
  * function toDateString()
  * @class Date
  * @type String
  * @return String
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Date.prototype.toDateString=function(){};

/**
  * function toTimeString()
  * @class Date
  * @type String
  * @return String
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Date.prototype.toTimeString=function(){};
/**
  * function toLocaleString()
  * @class Date
  * @type String
  * @return String
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Date.prototype.toLocaleString=function(){return "";};
/**
  * function toLocaleDateString()
  * @class Date
  * @type String
  * @return String
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Date.prototype.toLocaleDateString=function(){};
/**
  * function toLocaleTimeString()
  * @class Date
  * @type String
  * @return String
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Date.prototype.toLocaleTimeString=function(){};

/**
  * function valueOf()
  * @class Date
  * @type Object
  * @return Object
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Date.prototype.valueOf=function(){};

/**
  * function getTime()
  * @class Date
  * @type Number
  * @return Number
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Date.prototype.getTime=function(){};


/**
  * function getTime()
  * @class Date
  * @type Number
  * @return Number
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Date.prototype.getTime=function(){};
/**
  * function getFullYear()
  * @class Date
  * @type Number
  * @return Number
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Date.prototype.getFullYear=function(){};
/**
  * function getTime()
  * @class Date
  * @type Number
  * @return Number
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Date.prototype.getTime=function(){};
/**
  * function getUTCFullYear()
  * @class Date
  * @type Number
  * @return Number
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Date.prototype.getUTCFullYear=function(){};
/**
  * function getMonth()
  * @class Date
  * @type Number
  * @return Number
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Date.prototype.getMonth=function(){};
/**
  * function getUTCMonth()
  * @class Date
  * @type Number
  * @return Number
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Date.prototype.getUTCMonth=function(){};
/**
  * function getDate()
  * @class Date
  * @type Number
  * @return Number
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Date.prototype.getDate=function(){};
/**
  * function getUTCDate()
  * @class Date
  * @type Number
  * @return Number
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Date.prototype.getUTCDate=function(){};
/**
  * function getDay()
  * @class Date
  * @type Number
  * @return Number
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Date.prototype.getDay=function(){};
/**
  * function getUTCDay()
  * @class Date
  * @type Number
  * @return Number
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Date.prototype.getUTCDay=function(){};
/**
  * function getHours()
  * @class Date
  * @type Number
  * @return Number
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Date.prototype.getHours=function(){};
/**
  * function getUTCHours()
  * @class Date
  * @type Number
  * @return Number
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Date.prototype.getUTCHours=function(){};
/**
  * function getMinutes()
  * @class Date
  * @type Number
  * @return Number
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Date.prototype.getMinutes=function(){};
/**
  * function getUTCMinutes()
  * @class Date
  * @type Number
  * @return Number
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Date.prototype.getUTCMinutes=function(){};
/**
  * function getSeconds()
  * @class Date
  * @type Number
  * @return Number
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Date.prototype.getSeconds=function(){};
/**
  * function getUTCSeconds()
  * @class Date
  * @type Number
  * @return Number
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Date.prototype.getUTCSeconds=function(){};

/**
  * function getMilliseconds()
  * @class Date
  * @type Number
  * @return Number
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Date.prototype.getMilliseconds=function(){};
/**
  * function getUTCMilliseconds()
  * @class Date
  * @type Number
  * @return Number
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Date.prototype.getUTCMilliseconds=function(){};
/**
  * function getTimezoneOffset()
  * @class Date
  * @type Number
  * @return Number
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Date.prototype.getTimezoneOffset=function(){};
/**
  * function setTime(value)
  * @class Date
  * @type Number
  * @return Number
  * @param value Number
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Date.prototype.setTime=function(value){};

/**
  * function setMilliseconds(value)
  * @class Date
  * @type Number
  * @return Number
  * @param value Number
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Date.prototype.setMilliseconds=function(value){};
/**
  * function setUTCMilliseconds(value)
  * @class Date
  * @type Number
  * @return Number

  * @param ms Number
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Date.prototype.setUTCMilliseconds=function(ms){};
/**
  * function setSeconds(sec,ms)
  * @class Date
  * @type Number
  * @return Number
  * @param sec Number
  * @param ms Number
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Date.prototype.setSeconds=function(sec,ms){};
/**
  * function setUTCSeconds(sec,ms)
  * @class Date
  * @type Number
  * @return Number
  * @param sec Number
  * @param ms Number
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Date.prototype.setUTCSeconds=function(sec,ms){};
/**
  * function setMinutes(min,sec,ms)
  * @class Date
  * @type Number
  * @return Number
  * @param min Number
  * @param sec Number
  * @param ms Number
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Date.prototype.setMinutes=function(min,sec,ms){};
/**
  * function setUTCMinute(min,sec,ms)
  * @class Date
  * @type Number
  * @return Number
  * @param min Number
  * @param sec Number
  * @param ms Number
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Date.prototype.setUTCMinute=function(min,sec,ms){};
/**
  * function setHours(hour, min,sec,ms)
  * @class Date
  * @type Number
  * @return Number
  * @param hour Number
  * @param min Number
  * @param sec Number
  * @param ms Number
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Date.prototype.setHours=function(hour,min,sec,ms){};
/**
  * function setUTCHours(hour, min,sec,ms)
  * @class Date
  * @type Number
  * @return Number
  * @param hour Number
  * @param min Number
  * @param sec Number
  * @param ms Number
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Date.prototype.setUTCHours=function(hour,min,sec,ms){};

/**
  * function setDate(date)
  * @class Date
  * @type Number
  * @return Number
  * @param date Number
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Date.prototype.setDate=function(date){};

/**
  * function setUTCDate(date)
  * @class Date
  * @type Number
  * @return Number
  * @param date Number
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Date.prototype.setUTCDate=function(date){};

/**
  * function setMonth(month,date)
  * @class Date
  * @type Date
  * @return Date
  * @param date Number
  * @param month Number
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Date.prototype.setMonth=function(month,date){};
/**
  * function setUTCMonth(month,date)
  * @class Date
  * @type Date
  * @return Date
  * @param date Number
  * @param month Number
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Date.prototype.setUTCMonth=function(month,date){};
/**
  * function setFullYear(month,date)
  * @class Date
  * @type Date
  * @return Date
  * @param date Number
  * @param month Number
  * @param year Number
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Date.prototype.setFullYear=function(year, month,date){};
/**
  * function setUTCFullYear(month,date)
  * @class Date
  * @type Date
  * @return Date
  * @param date Number
  * @param month Number
  * @param year Number
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Date.prototype.setUTCFullYear=function(year, month,date){};

/**
  * Object Global
  * @super Object
  * @constructor
  * @class Global
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
function Global(){};
Global.prototype=new Object();
/**
  * Property NaN
  * @class Global
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Global.prototype.NaN=0;
/**
  * Property Infinity
  * @class Global
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Global.prototype.Infinity=0;
/**
  * Property Undefined
  * @class Global
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Global.prototype.Undefined=0;
/**
  * function eval(s)
  * @class Global
  * @param s String
  * @type Object
  * @return Object;
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */

//@GINO: Bug 197987 (Temp Fix)
/**
  * Property debugger
  * @class Global
  * @description Debugger keyword
 */
Global.prototype.debugger=null;

Global.prototype.eval=function(s){};
/**
  * function parseInt(s,radix)
  * @class Global
  * @param s String
  * @param radix Number
  * @type Number
  * @return Number;
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Global.prototype.parseInt=function(s,radix){};
/**
  * function parseFloat(s)
  * @class Global
  * @param s String
  * @type Object
  * @return Object;
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Global.prototype.parseFloat=function(s){};
/**
  * function isNaN(number)
  * @class Global
  * @param number String
  * @type Boolean
  * @return Boolean;
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Global.prototype.isNaN=function(number){};
/**
  * function isFinite(number)
  * @class Global
  * @param number String
  * @type Boolean
  * @return Boolean;
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Global.prototype.isFinite=function(number){};

/**
  * Object Math(\s)
  * @super Object
  * @constructor
  * @class Math
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
function Math(){};
Math.prototype=new Object();
/**
  * Property E
  * @class Math
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Math.E=0;
/**
  * Property LN10
  * @class Math
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Math.LN10=0;
/**
  * Property LN2
  * @class Math
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Math.LN2=0;
/**
  * Property LOG2E
  * @class Math
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Math.LOG2E=0;
/**
  * Property LOG10E
  * @class Math
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Math.LOG10E=0;
/**
  * Property PI
  * @class Math
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Math.PI=0;
/**
  * Property SQRT1_2
  * @class Math
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Math.SQRT1_2=0;
/**
  * Property SQRT2
  * @class Math
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Math.SQRT2=0;
/**
  * function abs(x)
  * @class Math
  * @param x Number
  * @type Number
  * @return Number
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Math.abs=function(x){};
/**
  * function acos(x)
  * @class Math
  * @param x Number
  * @type Number
  * @return Number
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Math.acos=function(x){};
/**
  * function asin(x)
  * @class Math
  * @param x Number
  * @type Number
  * @return Number
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Math.asin=function(x){};
/**
  * function atan(x)
  * @class Math
  * @param x Number
  * @type Number
  * @return Number
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Math.atan=function(x){};
/**
  * function atan2(x,y)
  * @class Math
  * @param x Number
   * @param y Number
  * @type Number
  * @return Number
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Math.atan2=function(x,y){};
/**
  * function ceil(x)
  * @class Math
  * @param x Number
  * @type Number
  * @return Number
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Math.ceil=function(x){};
/**
  * function cos(x)
  * @class Math
  * @param x Number
  * @type Number
  * @return Number
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Math.cos=function(x){};
/**
  * function exp(x)
  * @class Math
  * @param x Number
  * @type Number
  * @return Number
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Math.exp=function(x){};
/**
  * function floor(x)
  * @class Math
  * @param x Number
  * @type Number
  * @return Number
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Math.floor=function(x){};
/**
  * function log(x)
  * @class Math
  * @param x Number
  * @type Number
  * @return Number
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Math.log=function(x){};
/**
  * function max(arg)
  * @class Math
  * @param arg Array
  * @type Number
  * @return Number
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Math.max=function(arg){};
/**
  * function min(arg)
  * @class Math
  * @param arg Array
  * @type Number
  * @return Number
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Math.min=function(arg){};
/**
  * function pow(x,y)
  * @class Math
  * @param x Number
  @ @param y Number
  * @type Number
  * @return Number
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Math.pow=function(x,y){};
/**
  * function pow()
  * @class Math
  * @type Number
  * @return Number
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Math.random=function(){};
/**
  * function round(x)
  * @class Math
  * @param x Number
  * @type Number
  * @return Number
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Math.round=function(x){};
/**
  * function sin(x)
  * @class Math
  * @param x Number
  * @type Number
  * @return Number
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Math.sin=function(x){};
/**
  * function sqrt(x)
  * @class Math
  * @param x Number
  * @type Number
  * @return Number
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Math.sqrt=function(x){};
/**
  * function tan(x)
  * @class Math
  * @param x Number
  * @type Number
  * @return Number
  * @since   Standard ECMA-262 3rd. Edition 
  * @since   Level 2 Document Object Model Core Definition.
  * @link    http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Math.tan=function(x){};
/**
  * Object RegExp()
  * @super Object
  * @constructor
  * @class RegExp
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
function RegExp(){};
RegExp.prototype=new Object();
/**
  * function exec(string)
  * @param string String
  * @return Array
  * @type Array
  * @class RegExp
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
RegExp.prototype.exec=function(string){};
/**
  * function test(string)
  * @param string String
  * @return Boolean
  * @type Boolean
  * @class RegExp
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
RegExp.prototype.test=function(string){};
/**
  * property source
  * @type String
  * @class RegExp
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
RegExp.prototype.source="";
/**
  * property global
  * @type String
  * @class RegExp
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
RegExp.prototype.global="";

/**
  * property ignoreCase
  * @type Boolean
  * @class RegExp
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
RegExp.prototype.ignoreCase=false;
/**
  * property multiline
  * @type Boolean
  * @class RegExp
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
RegExp.prototype.multiline=false;
/**
  * property lastIndex
  * @type Number
  * @class RegExp
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
RegExp.prototype.lastIndex=0;
/**
  * Object Error(message)
  * @super Object
  * @constructor
  * @param message String
  * @class Error
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
function Error(message){};
Error.prototype=new Object();
/**
  * property name
  * @type String
  * @class Error
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Error.prototype.name="";
/**
  * property message
  * @type String
  * @class Error
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
Error.prototype.message="";
/**
  * Object EvalError()
  * @super Error
  * @constructor

  * @class EvalError
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
function EvalError(){};
EvalError.prototype=new Error("");
/**
  * Object RangeError()
  * @super Error
  * @constructor

  * @class RangeError
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
function RangeError(){};
RangeError.prototype=new Error("");
/**
  * Object ReferenceError()
  * @super Error
  * @constructor

  * @class ReferenceError
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
function ReferenceError(){};
ReferenceError.prototype=new Error("");
/**
  * Object SyntaxError()
  * @super Error
  * @constructor

  * @class SyntaxError
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
function SyntaxError(){};
SyntaxError.prototype=new Error("");
/**
  * Object TypeError()
  * @super Error
  * @constructor

  * @class TypeError
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
function TypeError(){};
TypeError.prototype=new Error("");
/**
  * Object URIError()
  * @super Error
  * @constructor

  * @class URIError
  * @since Standard ECMA-262 3rd. Edition
  * @since Level 2 Document Object Model Core Definition.
  * @link  http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/ecma-script-binding.html     
 */
function URIError(){};
URIError.prototype=new Error("");

//support for debugger keyword
var debugger = null;